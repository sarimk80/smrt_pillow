package com.example.smartpilow

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smartpilow.models.Feed
import com.example.smartpilow.models.SmartPillowModel
import com.example.smartpilow.services.RetrofitHelper
import com.example.smartpilow.services.SmartPillowApi
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    val db = Firebase.firestore



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment

        createNotificationChannel()
        val smartPillowApi = RetrofitHelper.getInstance().create(SmartPillowApi::class.java)


        GlobalScope.launch {
            val result = smartPillowApi.getData()

            getResponse(result)

        }

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    private suspend fun getResponse(result: Response<SmartPillowModel>) {
        if (result != null) {
            Log.d("secondFragment", result.body()?.feeds?.last().toString())

            withContext(Dispatchers.Main) {

                if(result.body()?.feeds?.last()?.field1?.toInt()!! > 95){
                    createNotification("Your patient heart rate rose above 95 bpm","High heart rate ")
                }
                else if(result.body()?.feeds?.last()?.field2?.toInt()!! > 37){
                    createNotification("Your patient temperature rose above normal body temperature","High Temperature Alert")
                }else if(result.body()?.feeds?.last()?.field1?.toInt()!! > 50 && !result.body()?.feeds?.last()?.field3?.toBoolean()!!){
                    createNotification("Your patient has woke up from bed","Wake up Alert")
                }


                var feed = Feed(
                    created_at = result.body()?.feeds?.last()?.created_at!!,
                    entry_id = result.body()?.feeds?.last()?.entry_id!!,
                    field1 = result.body()?.feeds?.last()?.field1!!,
                    field2 = result.body()?.feeds?.last()?.field2!!,
                    field3 = result.body()?.feeds?.last()?.field3!!

                )
                view?.findViewById<TextView>(R.id.heart_beat)?.text = "HeartBeat " + feed.field1
                view?.findViewById<TextView>(R.id.temperature)?.text = "Temperature " + feed.field2
                view?.findViewById<TextView>(R.id.is_sleeping)?.text = "Is sleeping " + feed.field3

                db.collection("readings").document(feed.entry_id.toString())
                    .set(feed)
                    .addOnSuccessListener { task ->
                        Toast.makeText(
                            context, "Successfully send to database",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            context, "Failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            }

        }
    }

    private fun createNotification( test:String,  title:String){
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(requireContext(), "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentText(test)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(null)
                .setContentIntent(null)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager =
           requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager?.notify(
            123,
            notificationBuilder.build()
        ) //integer id, to distinguish between different notifications.


    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "CHANNEL_ID"
            val description = "Detail about channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager: NotificationManager? =requireContext().getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as NotificationManager
            notificationManager?.createNotificationChannel(channel)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }

        view.findViewById<ImageButton>(R.id.refresh_button).setOnClickListener{
            val smartPillowApi = RetrofitHelper.getInstance().create(SmartPillowApi::class.java)


            GlobalScope.launch {
                val result = smartPillowApi.getData()

                getResponse(result)

            }
        }
    }


}
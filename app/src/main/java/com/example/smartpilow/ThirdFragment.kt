package com.example.smartpilow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.smartpilow.adapter.ListAdpater
import com.example.smartpilow.models.Feed
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlin.math.log


class ThirdFragment : Fragment() {

    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var arrayList: ArrayList<Feed> = ArrayList()
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val listView = view.findViewById<ListView>(R.id.list)

        db.collection("readings")
            .orderBy("entry_id",Query.Direction.DESCENDING)
            .get()


            .addOnSuccessListener { result ->

                val customResult = result.toObjects<Feed>()


                for (documents in customResult){
                    Log.d("TAG", customResult.toString())
                    arrayList.add(Feed(created_at = documents.created_at, entry_id = documents.entry_id, field1 = documents.field1, field2 = documents.field2, field3 = documents.field3))
                    val adapter = ListAdpater(requireContext(),arrayList)


                    listView.adapter = adapter
                }

            }
            .addOnFailureListener { result ->
                Toast.makeText(context, result.toString(),
                    Toast.LENGTH_LONG).show()
            }







        return view
    }


}
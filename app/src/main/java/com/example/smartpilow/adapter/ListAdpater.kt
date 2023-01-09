package com.example.smartpilow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.smartpilow.R
import com.example.smartpilow.models.Feed
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

class ListAdpater(private  val context: Context, private  val data:ArrayList<Feed>) : BaseAdapter() {

    private lateinit var heat_beat_list: TextView
    private lateinit var temperature_list: TextView
    private lateinit var is_sleeping_list: TextView
    private  lateinit var created_date: TextView
    private  lateinit var id:TextView
    private  lateinit var formattedDate:String

    override fun getCount(): Int {
        return  data.size
    }

    override fun getItem(p0: Int): Any {
        return  p0
    }

    override fun getItemId(p0: Int): Long {
        return  p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        convertView = LayoutInflater.from(context).inflate(R.layout.list_data,p2,false)

        heat_beat_list = convertView.findViewById(R.id.heart_beat_list)
        temperature_list = convertView.findViewById(R.id.temperature_list)
        is_sleeping_list = convertView.findViewById(R.id.is_sleeping_list)
        created_date = convertView.findViewById(R.id.created_at)
        id = convertView.findViewById(R.id.id)


        try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val customDate = date.parse(data[p0].created_at)
            var calendar = Calendar.getInstance()
            calendar.time = customDate
            calendar.add(customDate.hours,5)
            val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            val formatted = formatter.format(calendar.time)
            formattedDate= formatted
        }catch (e:Exception){
        formattedDate = data[0].created_at
        }







        heat_beat_list.text = "HeartBeat " + data[p0].field1
        temperature_list.text = "Temperature " + data[p0].field2
        is_sleeping_list.text = "IsSleeping " + data[p0].field3
        created_date.text = "Created At " + formattedDate
        id.text = "Id "+ data[p0].entry_id.toString()

        return convertView
    }
}
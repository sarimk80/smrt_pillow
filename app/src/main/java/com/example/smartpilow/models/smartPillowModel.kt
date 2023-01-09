package com.example.smartpilow.models

data class SmartPillowModel (

    val channel: Channel,
    val feeds: List<Feed>
)


data class Channel (
    val id: Long,
    val name: String,
    val latitude: String,
    val longitude: String,
    val field1: String,
    val field2: String,
    val field3: String,

    val created_at: String,

    val updated_at: String,

    val last_entry_id: Long
)

data class Feed (



    val created_at: String = "",

    val entry_id: Long = 0,

    val field1: String = "",
    val field2: String = "",
    val field3: String = ""
){
    constructor(): this("",0,"","","")
}
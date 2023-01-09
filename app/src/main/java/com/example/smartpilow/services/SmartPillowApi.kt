package com.example.smartpilow.services

import com.example.smartpilow.models.SmartPillowModel
import retrofit2.Response
import retrofit2.http.GET

//https://api.thingspeak.com/channels/1868150/feeds.json?api_key=ZYFX22DXKB1RC247
interface SmartPillowApi  {

    @GET("channels/1868150/feeds.json?api_key=ZYFX22DXKB1RC247")
    suspend fun getData() : Response<SmartPillowModel>
}
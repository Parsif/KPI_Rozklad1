package com.example.kpi_rozklad.data.network

import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.example.kpi_rozklad.data.network.response.TeacherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.rozklad.org.ua/v2/groups/"

interface KpiApiService {
    @GET("{groupName}/lessons")
    fun getTwoWeeksSchedule(@Path("groupName") groupName: String): Deferred<TeacherResponse>

    companion object {
        operator fun invoke() : KpiApiService {
            val okkHttpClient = OkHttpClient.Builder().build()
            return Retrofit.Builder().baseUrl(BASE_URL).client(okkHttpClient).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory()).build().create(KpiApiService::class.java)
        }
    }
}
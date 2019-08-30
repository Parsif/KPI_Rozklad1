package com.example.kpi_rozklad.utilities

import androidx.room.TypeConverter
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

class DataConverter {
    @TypeConverter
    fun fromScheduleList(schedule: List<ScheduleDay>) : String {
//        if(schedule.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ScheduleDay>>() { }.type
        println("fromscheduleList")
        return Gson().toJson(schedule, type)
    }

    @TypeConverter
    fun toScheduleList(schedule: String) : List<ScheduleDay> {
//        if(schedule.isNullOrEmpty()) return null
        println("toscheduleList")

        val type = object : TypeToken<List<ScheduleDay>>() { }.type
        return Gson().fromJson(schedule, type)
    }
}
package com.example.kpi_rozklad.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kpi_rozklad.data.db.dao.ScheduleDao
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay

@Database(entities = [ScheduleDay::class], version = 1)
abstract class ScheduleDatabase : RoomDatabase() {
    abstract fun getScheduleDao() : ScheduleDao

    companion object {
        private var INSTANCE : ScheduleDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context : Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE = Room.databaseBuilder(context.applicationContext, ScheduleDatabase::class.java, "scheduleDatabase.db").build()
            INSTANCE
        }
    }
}
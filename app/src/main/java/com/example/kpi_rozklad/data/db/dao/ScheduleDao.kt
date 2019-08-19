package com.example.kpi_rozklad.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay


@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(schedule: List<ScheduleDay>)

    @Query("select * from schedule_table")
    fun getSchedule() : List<ScheduleDay>

//  Retrieving schedule for today
}
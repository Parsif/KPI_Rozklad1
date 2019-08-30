package com.example.kpi_rozklad.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.example.kpi_rozklad.utilities.enums.WeekNumber


@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(schedule: ScheduleDay)

    @Query("select * from schedule_table")
    fun getSchedule() : LiveData<List<ScheduleDay>>

    @Query("SELECT * FROM schedule_table WHERE lessonWeek = 1")
    fun getFirstWeekSchedule(): LiveData<List<ScheduleDay>>

    @Query("SELECT * FROM schedule_table WHERE lessonWeek = 2")
    fun getSecondWeekSchedule(): LiveData<List<ScheduleDay>>

    @Transaction
    suspend fun upsertAll(schedule: List<ScheduleDay>) = schedule.forEach{ upsert(it) }


//  Retrieving schedule for today
}
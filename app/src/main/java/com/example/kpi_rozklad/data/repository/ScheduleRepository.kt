package com.example.kpi_rozklad.data.repository

import androidx.lifecycle.LiveData
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.example.kpi_rozklad.data.network.response.ScheduleResponse
import com.example.kpi_rozklad.utilities.enums.WeekNumber

interface ScheduleRepository {
    suspend fun getFirstWeekSchedule(): LiveData<List<ScheduleDay>>
    suspend fun getSecondWeekSchedule(): LiveData<List<ScheduleDay>>
}
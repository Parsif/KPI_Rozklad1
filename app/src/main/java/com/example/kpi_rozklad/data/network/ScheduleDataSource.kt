package com.example.kpi_rozklad.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kpi_rozklad.data.network.response.ScheduleResponse

interface ScheduleDataSource {
    val schedule: LiveData<ScheduleResponse>

    suspend fun fetchSchedule()
}
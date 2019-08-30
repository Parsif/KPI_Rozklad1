package com.example.kpi_rozklad.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kpi_rozklad.data.network.response.ScheduleResponse
import com.example.kpi_rozklad.utilities.NoConnectivityExcetion

class ScheduleDataSourceImpl(private val apiService: KpiApiService) : ScheduleDataSource {

    private val _schedule = MutableLiveData<ScheduleResponse>()
    override val schedule: LiveData<ScheduleResponse>
        get() =_schedule

    override suspend fun fetchSchedule(){
        try {
            val response = apiService.getTwoWeeksSchedule("ік-81").await()
            _schedule.postValue(response)
        } catch (e : NoConnectivityExcetion) {
            Log.d("NoConnectivityException", e.localizedMessage)
        }
    }
}
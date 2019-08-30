package com.example.kpi_rozklad.data.repository

import androidx.lifecycle.LiveData
import com.example.kpi_rozklad.data.db.dao.ScheduleDao
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.example.kpi_rozklad.data.network.ScheduleDataSource
import com.example.kpi_rozklad.data.network.response.ScheduleResponse
import com.example.kpi_rozklad.utilities.enums.WeekNumber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleRepositoryImpl(private val scheduleDao: ScheduleDao,
                             private val scheduleDataSource: ScheduleDataSource) : ScheduleRepository {

    init {
        scheduleDataSource.schedule.observeForever{ response ->
            response?.let {
                saveScheduleToDb(it)
            }
        }
    }


    override suspend fun getFirstWeekSchedule(): LiveData<List<ScheduleDay>> {
        return withContext(Dispatchers.IO){
//            if(scheduleDataSource.schedule.value == null) scheduleDataSource.fetchSchedule()
            return@withContext scheduleDao.getFirstWeekSchedule()
        }
    }

    override suspend fun getSecondWeekSchedule(): LiveData<List<ScheduleDay>> {
        return withContext(Dispatchers.IO){
            //            if(scheduleDataSource.schedule.value == null) scheduleDataSource.fetchSchedule()
            return@withContext scheduleDao.getSecondWeekSchedule()
        }
    }

    private fun saveScheduleToDb(scheduleResponse: ScheduleResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            scheduleDao.upsertAll(scheduleResponse.data)
        }

    }
}
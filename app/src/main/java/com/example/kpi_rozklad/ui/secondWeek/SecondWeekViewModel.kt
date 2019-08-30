package com.example.kpi_rozklad.ui.secondWeek

import androidx.lifecycle.ViewModel;
import com.example.kpi_rozklad.data.repository.ScheduleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class SecondWeekViewModel(scheduleRepository: ScheduleRepository) : ViewModel() {
    val schedule by lazy {
        GlobalScope.async(Dispatchers.IO) {
            scheduleRepository.getSecondWeekSchedule()
        }
    }
}

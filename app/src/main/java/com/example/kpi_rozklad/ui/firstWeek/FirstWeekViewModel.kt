package com.example.kpi_rozklad.ui.firstWeek

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope
import com.example.kpi_rozklad.data.repository.ScheduleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class FirstWeekViewModel(scheduleRepository: ScheduleRepository) : ViewModel() {
    val schedule by lazy {
        viewModelScope.async(Dispatchers.IO) {
            scheduleRepository.getFirstWeekSchedule()
        }
    }
}

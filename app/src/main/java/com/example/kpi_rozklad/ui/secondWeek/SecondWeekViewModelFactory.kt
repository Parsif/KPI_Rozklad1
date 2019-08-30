package com.example.kpi_rozklad.ui.secondWeek

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kpi_rozklad.data.repository.ScheduleRepository

class SecondWeekViewModelFactory(private val scheduleRepository: ScheduleRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SecondWeekViewModel(scheduleRepository) as T
    }

}
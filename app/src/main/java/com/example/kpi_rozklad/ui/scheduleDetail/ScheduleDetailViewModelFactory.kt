package com.example.kpi_rozklad.ui.scheduleDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScheduleDetailViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScheduleDetailViewModel() as T
    }
}
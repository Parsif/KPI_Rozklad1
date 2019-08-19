package com.example.kpi_rozklad.data.network.response

import com.example.kpi_rozklad.data.db.entitie.ScheduleDay

data class TeacherResponse(
    val data: List<ScheduleDay>
)
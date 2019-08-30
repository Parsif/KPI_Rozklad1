package com.example.kpi_rozklad.data.network.response


import com.example.kpi_rozklad.data.db.entitie.ScheduleDay

data class ScheduleResponse(
    val data: List<ScheduleDay>
)
package com.example.kpi_rozklad.data.db.entitie


import com.google.gson.annotations.SerializedName

data class Teacher(
    @SerializedName("teacher_full_name")
    val teacherFullName: String,
    @SerializedName("teacher_id")
    val teacherId: String,
    @SerializedName("teacher_name")
    val teacherName: String,
    @SerializedName("teacher_rating")
    val teacherRating: String,
    @SerializedName("teacher_short_name")
    val teacherShortName: String,
    @SerializedName("teacher_url")
    val teacherUrl: String
)
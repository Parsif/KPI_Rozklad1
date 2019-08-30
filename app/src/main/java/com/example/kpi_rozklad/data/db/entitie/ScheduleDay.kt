package com.example.kpi_rozklad.data.db.entitie


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kpi_rozklad.data.db.entitie.Teacher
import com.google.gson.annotations.SerializedName

const val SCHEDULE_ID = 0

@Entity(tableName = "schedule_table")
data class ScheduleDay(
    @SerializedName("day_name")
    val dayName: String,
    @SerializedName("day_number")
    val dayNumber: String,
    @SerializedName("group_id")
    val groupId: String,
    @SerializedName("lesson_full_name")
    val lessonFullName: String,
    @SerializedName("lesson_id")
    val lessonId: String,
    @SerializedName("lesson_name")
    val lessonName: String,
    @SerializedName("lesson_number")
    val lessonNumber: String,
    @SerializedName("lesson_room")
    val lessonRoom: String,
    @SerializedName("lesson_type")
    val lessonType: String,
    @SerializedName("lesson_week")
    val lessonWeek: String,
    val rate: String,
    @SerializedName("teacher_name")
    val teacherName: String,

//    @Embedded(prefix = "teacher_") // error
//    val teachers: List<Teacher>,
    @SerializedName("time_end")
    val timeEnd: String,
    @SerializedName("time_start")
    val timeStart: String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = SCHEDULE_ID
}
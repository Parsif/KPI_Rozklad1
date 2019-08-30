package com.example.kpi_rozklad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kpi_rozklad.R
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import java.util.*

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    private val scheduleList: MutableList<ScheduleDay> = LinkedList()

    fun setData(schedule: List<ScheduleDay>) {
        scheduleList.clear()
        scheduleList.addAll(schedule)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.schedule_day_placeholder, parent, false))
    }

    override fun getItemCount() = scheduleList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(scheduleList[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val lessonCount = view.findViewById<TextView>(R.id.lesson_count)
        private val lessonName = view.findViewById<TextView>(R.id.lesson_name)
        private val lessonTime = view.findViewById<TextView>(R.id.lesson_time)
        private val lessonType = view.findViewById<TextView>(R.id.lesson_type)
        private val lessonLocation = view.findViewById<TextView>(R.id.lesson_location)
        private val lessonTeacher = view.findViewById<TextView>(R.id.lesson_teacher)


      init {
          view.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action, null))
      }

        fun bind(schedule: ScheduleDay) {
            lessonCount.text = schedule.lessonNumber
            lessonName.text = schedule.lessonName
            lessonTime.text = "${schedule.timeStart} - ${schedule.timeEnd}"
            lessonType.text = schedule.lessonType
            lessonLocation.text = schedule.lessonRoom
            lessonTeacher.text = schedule.teacherName

        }
    }
}
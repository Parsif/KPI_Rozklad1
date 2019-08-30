package com.example.kpi_rozklad.ui.firstWeek

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation

import com.example.kpi_rozklad.R
import com.example.kpi_rozklad.adapters.ScheduleAdapter
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.example.kpi_rozklad.utilities.ScopedFragment
import kotlinx.android.synthetic.main.first_week_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class FirstWeekFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()
    private val firstWeekViewModelFactory: FirstWeekViewModelFactory by instance()
    private val scheduleAdapter : ScheduleAdapter by instance()

    private val viewModel by lazy {
        ViewModelProviders.of(this, firstWeekViewModelFactory).get(FirstWeekViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_week_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        first_schedule_recycler_view.adapter = scheduleAdapter
        
        launch {
            viewModel.schedule.await().observe(this@FirstWeekFragment, Observer {response ->
                updateUI(response)
            })
        }

    }

    private fun updateUI(schedule: List<ScheduleDay>) {
        println(schedule)
        scheduleAdapter.setData(schedule)
    }




}

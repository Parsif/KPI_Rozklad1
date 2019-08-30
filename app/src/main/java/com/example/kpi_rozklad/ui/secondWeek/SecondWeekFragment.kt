package com.example.kpi_rozklad.ui.secondWeek

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.kpi_rozklad.R
import com.example.kpi_rozklad.adapters.ScheduleAdapter
import com.example.kpi_rozklad.data.db.entitie.ScheduleDay
import com.example.kpi_rozklad.utilities.ScopedFragment
import kotlinx.android.synthetic.main.second_week_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class SecondWeekFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()

    private val secondWeekViewModelFactory: SecondWeekViewModelFactory by instance()
    private val scheduleAdapter : ScheduleAdapter by instance()

    private val viewModel by lazy {
        ViewModelProviders.of(this, secondWeekViewModelFactory).get(SecondWeekViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_week_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        second_schedule_recycler_view.adapter = scheduleAdapter

        launch {
            viewModel.schedule.await().observe(this@SecondWeekFragment, Observer {
                updateUI(it)
            })
        }
    }

    private fun updateUI(schedule: List<ScheduleDay>) {
        scheduleAdapter.setData(schedule)
    }

}

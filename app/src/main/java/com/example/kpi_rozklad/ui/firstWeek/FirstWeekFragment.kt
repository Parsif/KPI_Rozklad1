package com.example.kpi_rozklad.ui.firstWeek

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.kpi_rozklad.R
import com.example.kpi_rozklad.data.network.KpiApiService
import kotlinx.android.synthetic.main.first_week_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FirstWeekFragment : Fragment() {

    private lateinit var viewModel: FirstWeekViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_week_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirstWeekViewModel::class.java)
        val service = KpiApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val response = service.getTwoWeeksSchedule("ік-81").await()
            textView.text = response.toString()

        }

    }

}

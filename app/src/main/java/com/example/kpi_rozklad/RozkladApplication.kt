package com.example.kpi_rozklad

import android.app.Application
import com.example.kpi_rozklad.adapters.ScheduleAdapter
import com.example.kpi_rozklad.data.db.ScheduleDatabase
import com.example.kpi_rozklad.data.db.dao.ScheduleDao
import com.example.kpi_rozklad.data.network.KpiApiService
import com.example.kpi_rozklad.data.network.ScheduleDataSource
import com.example.kpi_rozklad.data.network.ScheduleDataSourceImpl
import com.example.kpi_rozklad.data.repository.ScheduleRepository
import com.example.kpi_rozklad.data.repository.ScheduleRepositoryImpl
import com.example.kpi_rozklad.ui.firstWeek.FirstWeekViewModelFactory
import com.example.kpi_rozklad.ui.scheduleDetail.ScheduleDetailViewModelFactory
import com.example.kpi_rozklad.ui.secondWeek.SecondWeekViewModelFactory
import com.example.kpi_rozklad.utilities.interceptors.NoConnectivityInterceptor
import com.example.kpi_rozklad.utilities.interceptors.NoConnectivityInterceptorImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class RozkladApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@RozkladApplication))

        bind<NoConnectivityInterceptor>() with singleton { NoConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ScheduleDatabase(instance()) }
        bind<ScheduleDao>() with singleton { instance<ScheduleDatabase>().getScheduleDao() }
        bind() from singleton { KpiApiService(instance()) }
        bind<ScheduleDataSource>() with singleton { ScheduleDataSourceImpl(instance()) }
        bind<ScheduleRepository>() with singleton { ScheduleRepositoryImpl(instance(), instance()) }
        bind() from singleton { FirstWeekViewModelFactory(instance()) }
        bind() from singleton { SecondWeekViewModelFactory(instance()) }
        bind() from singleton { ScheduleDetailViewModelFactory() }
        bind() from provider { ScheduleAdapter() }

    }
}
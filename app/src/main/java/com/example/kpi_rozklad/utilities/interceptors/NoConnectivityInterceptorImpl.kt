package com.example.kpi_rozklad.utilities.interceptors

import android.content.Context
import android.net.ConnectivityManager
import com.example.kpi_rozklad.utilities.NoConnectivityExcetion
import okhttp3.Interceptor
import okhttp3.Response

class NoConnectivityInterceptorImpl(private val context: Context) : NoConnectivityInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline()) throw NoConnectivityExcetion()
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {
        val cm = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected

    }
}
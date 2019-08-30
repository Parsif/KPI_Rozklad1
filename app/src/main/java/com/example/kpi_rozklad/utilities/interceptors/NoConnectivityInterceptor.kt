package com.example.kpi_rozklad.utilities.interceptors

import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response

interface NoConnectivityInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response
}
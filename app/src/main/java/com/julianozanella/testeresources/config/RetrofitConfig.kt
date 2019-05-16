package com.julianozanella.testeresources.config

import com.julianozanella.testeresources.services.ResourceService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class RetrofitConfig {

    private var baseRetrofit: Retrofit? = null

    //aumentei o tempo pq a consulta demora muito....
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.MINUTES)
        .connectTimeout(60, TimeUnit.MINUTES)
        .build()

    private fun getRetrofit(): Retrofit {
        if (baseRetrofit == null) {
            baseRetrofit = Retrofit.Builder()
                .baseUrl("http://portal.greenmilesoftware.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
        return baseRetrofit!!
    }

    fun getResourceService() = this.getRetrofit().create(ResourceService::class.java)
}
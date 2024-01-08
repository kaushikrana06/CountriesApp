package com.kaushik.simplecountries.di

import com.kaushik.simplecountries.model.CountriesApi
import com.kaushik.simplecountries.model.CountriesService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiModule {
    private val BASE_URL = "https://countryapi.io/api/"

    @Provides
    fun provideCountriesApi(): CountriesApi {
        val apiKeyInterceptor = Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", "Isc9VqiKUHSgwflWZizj2btE6o7NyB7RUxRt7S3e")
                .build()

            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
            return@Interceptor chain.proceed(request)
        }

        val okHttpClient = okhttp3.OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }

    @Provides
    fun provideCountriesService(): CountriesService {
        return CountriesService()
    }

}
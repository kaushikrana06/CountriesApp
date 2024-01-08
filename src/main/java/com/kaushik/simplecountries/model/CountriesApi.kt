package com.kaushik.simplecountries.model

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesApi {
    @GET("all")
    fun getCountries(): Single<List<Country>>
}
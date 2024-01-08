package com.kaushik.simplecountries.model

import com.kaushik.simplecountries.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api: CountriesApi

    init {
        DaggerApiComponent.create().inject(this)

    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }

}
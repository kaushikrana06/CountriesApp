package com.kaushik.simplecountries.di

import com.kaushik.simplecountries.model.CountriesService
import com.kaushik.simplecountries.viewmodel.ListViewModel
import dagger.Component


@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}
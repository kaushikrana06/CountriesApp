package com.kaushik.simplecountries.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaushik.simplecountries.R
import com.kaushik.simplecountries.databinding.ItemCountryBinding
import com.kaushik.simplecountries.model.Country
import com.kaushik.simplecountries.util.loadImage
import com.kaushik.simplecountries.util.getProgressDrawable



class CountryListAdapter(var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(private val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root) {

        private val progressDrawable = getProgressDrawable(binding.root.context)

        fun bind(country: Country) {
            binding.name.text = country.countryName
            binding.capital.text = country.capital
            val mediumFlagUrl = country.flag?.get("medium") // Extract the medium flag URL
            binding.imageView.loadImage(mediumFlagUrl, progressDrawable)
        }
    }
}
package com.bsoft.weathercaseapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bsoft.weathercaseapp.data.repository.DetailsRepository
import com.bsoft.weathercaseapp.data.repository.HomeRepository

@Suppress("UNCHECKED_CAST")

class DetailsViewModelFactory(private val repository: DetailsRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}
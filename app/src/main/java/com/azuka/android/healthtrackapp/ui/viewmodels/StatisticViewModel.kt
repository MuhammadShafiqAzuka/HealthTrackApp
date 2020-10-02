package com.azuka.android.healthtrackapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.azuka.android.healthtrackapp.repositories.MainRepository

class StatisticsViewModel @ViewModelInject constructor(
    mainRepository: MainRepository
) : ViewModel() {

    var totalDistance = mainRepository.getTotalDistance()
    var totalTimeInMillis = mainRepository.getTotalTimeInMillis()
    var totalAvgSpeed = mainRepository.getTotalAverageSpeed()
    var totalCaloriesBurned = mainRepository.getTotalCaloriesBurn()

    var runsSortedByDate = mainRepository.getAllRunSortedByDate()
}
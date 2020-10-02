package com.azuka.android.healthtrackapp.repositories

import com.azuka.android.healthtrackapp.db.Run
import com.azuka.android.healthtrackapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDAO
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunSortedByDate() = runDao.getAllRunsSortedByDate()

    fun getAllRunSortedByDistance() = runDao.getAllRunsSortedByDistance()

    fun getAllRunSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunSortedByAverageSpeed() = runDao.getAllRunsSortedByAverageSpeed()

    fun getAllRunSortedByCaloriesBurn() = runDao.getAllRunsSortedByCaloriesBurn()

    fun getTotalAverageSpeed() = runDao.getTotalAverageSpeed()

    fun getTotalDistance() = runDao.getTotalDistance()

    fun getTotalCaloriesBurn() = runDao.getTotalCaloriesBurn()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

}
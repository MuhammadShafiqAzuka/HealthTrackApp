package com.azuka.android.healthtrackapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {

    //inset into db replace with new one
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    // sorted db by params in running table in Run class
    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calories_burn DESC")
    fun getAllRunsSortedByCaloriesBurn(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avg_speed DESC")
    fun getAllRunsSortedByAverageSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceMeter DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    //sum all time in running table
    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(calories_burn) FROM running_table")
    fun getTotalCaloriesBurn(): LiveData<Int>

    @Query("SELECT SUM(distanceMeter) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(avg_speed) FROM running_table")
    fun getTotalAverageSpeed(): LiveData<Float>

}
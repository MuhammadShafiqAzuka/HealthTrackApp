package com.azuka.android.healthtrackapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

//create db for table
@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timestamp: Long = 0L,
    var avg_speed: Float = 0f,
    var distanceMeter: Int = 0,
    var timeInMillis: Long = 0L,
    var calories_burn: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}
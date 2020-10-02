package com.azuka.android.healthtrackapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(Convertes::class)
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDAO(): RunDAO
}
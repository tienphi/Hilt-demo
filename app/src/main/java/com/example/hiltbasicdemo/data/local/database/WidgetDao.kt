package com.example.hiltbasicdemo.data.local.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WidgetDao {
    @Query("SELECT * FROM widgets")
    fun getWidgets(): Flow<List<WidgetEntity>>
}

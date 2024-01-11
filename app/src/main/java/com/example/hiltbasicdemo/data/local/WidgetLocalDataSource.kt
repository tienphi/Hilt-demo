package com.example.hiltbasicdemo.data.local

import com.example.hiltbasicdemo.data.local.database.WidgetEntity
import kotlinx.coroutines.flow.Flow

interface WidgetLocalDataSource {
    suspend fun getWidgets(): Flow<List<WidgetEntity>>
}

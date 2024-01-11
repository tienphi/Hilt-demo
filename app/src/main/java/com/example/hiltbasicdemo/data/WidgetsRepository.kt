package com.example.hiltbasicdemo.data

import kotlinx.coroutines.flow.Flow

interface WidgetsRepository {
    suspend fun getWidgets(): Flow<List<Widget>>
}
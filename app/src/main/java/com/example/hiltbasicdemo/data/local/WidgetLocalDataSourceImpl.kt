package com.example.hiltbasicdemo.data.local

import com.example.hiltbasicdemo.data.local.database.WidgetDao
import com.example.hiltbasicdemo.data.local.database.WidgetEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WidgetLocalDataSourceImpl @Inject constructor(
    private val widgetDao: WidgetDao,
    private val ioDispatcher: CoroutineDispatcher
) : WidgetLocalDataSource {
    override suspend fun getWidgets(): Flow<List<WidgetEntity>> =
        withContext(ioDispatcher) {
            widgetDao.getWidgets()
        }
}

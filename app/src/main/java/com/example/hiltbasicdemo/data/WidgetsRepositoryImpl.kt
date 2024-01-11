package com.example.hiltbasicdemo.data

import com.example.hiltbasicdemo.data.local.WidgetLocalDataSource
import com.example.hiltbasicdemo.data.local.database.WidgetEntity
import com.example.hiltbasicdemo.data.local.database.asExternalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WidgetsRepositoryImpl @Inject constructor(
    private val widgetLocalDataSource: WidgetLocalDataSource,
    private val externalScope: CoroutineScope
) : WidgetsRepository {
    override suspend fun getWidgets(): Flow<List<Widget>> = externalScope.async {
        widgetLocalDataSource.getWidgets().map { list ->
            convertToWidget(list)
        }
    }.await()

    private fun convertToWidget(entityList: List<WidgetEntity>): List<Widget> {
        if (entityList.isEmpty()) return emptyList()
        val result: MutableList<Widget> = mutableListOf()
        for (widget in entityList) {
            result.add(widget.asExternalModel())
        }
        return result
    }
}

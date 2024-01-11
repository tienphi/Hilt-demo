package com.example.hiltbasicdemo.di

import com.example.hiltbasicdemo.data.WidgetsRepository
import com.example.hiltbasicdemo.data.WidgetsRepositoryImpl
import com.example.hiltbasicdemo.data.local.WidgetLocalDataSource
import com.example.hiltbasicdemo.data.local.WidgetLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class WidgetModule {
    @Binds
    abstract fun bindWidgetLocalDataSource(
        widgetLocalDataSourceImpl: WidgetLocalDataSourceImpl
    ): WidgetLocalDataSource

    @Binds
    abstract fun bindWidgetRepository(
        widgetsRepositoryImpl: WidgetsRepositoryImpl
    ): WidgetsRepository
}

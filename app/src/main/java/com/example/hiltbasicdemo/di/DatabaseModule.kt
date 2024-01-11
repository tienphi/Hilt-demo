package com.example.hiltbasicdemo.di

import android.content.Context
import com.example.hiltbasicdemo.data.local.database.AppDatabase
import com.example.hiltbasicdemo.data.local.database.WidgetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideWidgetDao(appDatabase: AppDatabase): WidgetDao {
        return appDatabase.widgetDao()
    }
}
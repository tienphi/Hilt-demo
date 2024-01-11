package com.example.hiltbasicdemo.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hiltbasicdemo.data.Widget

@Entity(tableName = "widgets")
data class WidgetEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val name: String
)

fun WidgetEntity.asExternalModel() = Widget(
    id = uid.toString(),
    name = name
)

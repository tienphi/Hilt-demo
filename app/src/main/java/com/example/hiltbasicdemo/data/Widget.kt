package com.example.hiltbasicdemo.data

import com.example.hiltbasicdemo.data.local.database.WidgetEntity

data class Widget(
    val id: String,
    val name: String
)

fun Widget.asEntity() = WidgetEntity(
    uid = id.toIntOrNull() ?: 0,
    name = name
)

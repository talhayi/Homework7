package com.example.homework7.data.model

import java.util.Date

data class Todo(
    var id:String,
    var title: String,
    var description: String,
    var date: Date = Date()
)
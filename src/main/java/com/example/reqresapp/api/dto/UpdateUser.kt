package com.example.reqresapp.api.dto

import java.util.Date

data class UpdateUserCommand (
    val name: String,
    val job: String,
)

data class UpdateUserResponse (
    val id: String,
    val name: String,
    val job: String,
    val updatedAt: Date,
)
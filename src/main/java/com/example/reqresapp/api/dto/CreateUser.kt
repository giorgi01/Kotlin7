package com.example.reqresapp.api.dto

import java.util.Date

data class CreateUserCommand (
    val name: String,
    val job: String,
)

data class CreateUserResponse (
    val id : String,
    val name: String,
    val job: String,
    val createdAt: Date
)
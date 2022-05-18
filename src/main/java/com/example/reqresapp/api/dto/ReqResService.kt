package com.example.reqresapp.api.dto

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ReqResService {
    @GET("users")
    fun getUsers(@Query("page")page: Int): Call<ReqResData<List<User>>>

    @GET("users/{userId}")
    fun getUser(@Path("userId")id: Long): Call<ReqResData<User>>

    @POST("users")
    fun createUser(@Body user: CreateUserCommand) : Call<CreateUserResponse>

    @PUT("users/{userId}")
    fun updateUser(@Body user: UpdateUserCommand, @Path("userId")id: Long) : Call<UpdateUserResponse>
}
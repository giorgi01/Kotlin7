  package com.example.reqresapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.reqresapp.api.dto.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

  class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.initClient()

        RestClient.reqResApi.getUser(1).enqueue(object : Callback<ReqResData<User>>{
            override fun onResponse(
                call: Call<ReqResData<User>>,
                response: Response<ReqResData<User>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.toString()?.let { Log.d("log:", it) }
                }
            }

            override fun onFailure(call: Call<ReqResData<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        RestClient.reqResApi.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>> {
            override fun onResponse(
                call: Call<ReqResData<List<User>>>,
                response: Response<ReqResData<List<User>>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.forEach { user -> Log.d("log:", user.toString()) }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        RestClient.reqResApi.createUser(CreateUserCommand("John Doe", "Developer"))
            .enqueue(object : Callback<CreateUserResponse> {
                override fun onResponse(
                    call: Call<CreateUserResponse>,
                    response: Response<CreateUserResponse>
                ) {
                    if(response.isSuccessful){
                        response.body()?.id?.let { Log.d("log:", it) }
                        response.body()?.name?.let { Log.d("log:", it) }
                        response.body()?.job?.let { Log.d("log:", it) }
                    }
                }

                override fun onFailure(call: Call<CreateUserResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        RestClient.reqResApi.updateUser(UpdateUserCommand("Jason Doe", "Programmer"), 1)
            .enqueue(object: Callback<UpdateUserResponse>{
                override fun onResponse(
                    call: Call<UpdateUserResponse>,
                    response: Response<UpdateUserResponse>
                ) {
                    response.body()?.id?.let { Log.d("log:", it) }
                    response.body()?.name?.let { Log.d("log:", it) }
                    response.body()?.job?.let { Log.d("log:", it) }
                }

                override fun onFailure(call: Call<UpdateUserResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            } )
    }
}
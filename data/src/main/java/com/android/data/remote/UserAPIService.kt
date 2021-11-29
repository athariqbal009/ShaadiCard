package com.android.data.remote

import com.android.data.remote.models.UserDTO
import retrofit2.Response
import retrofit2.http.GET

interface UserAPIService {
    @GET("api/?results=10")
    suspend fun getUsers(): Response<UserDTO>
}
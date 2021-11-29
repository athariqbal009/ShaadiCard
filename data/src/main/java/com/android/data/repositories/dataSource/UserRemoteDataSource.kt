package com.android.data.repositories.dataSource

import com.android.data.remote.models.UserDTO
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUsers(): Response<UserDTO>
}
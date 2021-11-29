package com.android.data.repositories.dataSourceImpl

import com.android.data.remote.UserAPIService
import com.android.data.remote.models.UserDTO
import com.android.data.repositories.dataSource.UserRemoteDataSource
import retrofit2.Response

class UserRemoteDataSourceImpl(private val userAPIService: UserAPIService): UserRemoteDataSource {
    override suspend fun getUsers(): Response<UserDTO> {
        return userAPIService.getUsers()
    }
}
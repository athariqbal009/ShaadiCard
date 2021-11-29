package com.android.domain.repositories

import com.android.domain.models.UserModel
import com.android.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserDetails(): Resource<List<UserModel>>
    suspend fun saveUserDetails(userModel: List<UserModel>)
    suspend fun getSavedUser():Flow<List<UserModel>>
    suspend fun updateSavedUser(id: Int, status: String)
}
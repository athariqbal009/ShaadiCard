package com.android.data.repositories.dataSource

import com.android.domain.models.UserModel
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun saveUsers(users: List<UserModel>)
    fun getSavedUsers(): Flow<List<UserModel>>
    suspend fun updateSavedUser(id: Int, status: String)
}
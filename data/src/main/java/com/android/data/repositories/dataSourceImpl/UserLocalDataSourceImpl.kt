package com.android.data.repositories.dataSourceImpl

import android.util.Log
import com.android.data.local.dao.UserDAO
import com.android.data.mappers.mapToUserEntityList
import com.android.data.mappers.mapToUserEntityModel
import com.android.data.mappers.mapToUserModelList
import com.android.data.repositories.dataSource.UserLocalDataSource
import com.android.domain.models.UserModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserLocalDataSourceImpl(
    private val userDAO: UserDAO
): UserLocalDataSource {
    override suspend fun saveUsers(users: List<UserModel>) {
        val ids = userDAO.addUsers(users.mapToUserEntityList())
        Log.d("UserLocalDataSourceImpl", ids.toString())
    }

    override fun getSavedUsers(): Flow<List<UserModel>> {
        return userDAO.getAllUsers().mapToUserModelList()
    }

    override suspend fun updateSavedUser(id: Int, status: String) {
        val ids = userDAO.updateUser(id, status)
        Log.d("UserLocalDataSourceImpl", ids.toString())
    }
}
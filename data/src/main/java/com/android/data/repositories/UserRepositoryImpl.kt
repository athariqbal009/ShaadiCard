package com.android.data.repositories

import com.android.data.mappers.mapToUserList
import com.android.domain.utils.Resource
import com.android.data.remote.models.UserDTO
import com.android.data.repositories.dataSource.UserLocalDataSource
import com.android.data.repositories.dataSource.UserRemoteDataSource
import com.android.domain.models.UserModel
import com.android.domain.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {
    override suspend fun getUserDetails(): Resource<List<UserModel>> {
        return responseToResource(userRemoteDataSource.getUsers())
    }

    override suspend fun saveUserDetails(userModel: List<UserModel>) {
        userLocalDataSource.saveUsers(userModel)
    }

    override suspend fun getSavedUser(): Flow<List<UserModel>> {
        return userLocalDataSource.getSavedUsers()
    }

    override suspend fun updateSavedUser(id: Int, status: String) {
        userLocalDataSource.updateSavedUser(id, status)
    }

    private fun responseToResource(response: Response<UserDTO>): Resource<List<UserModel>> {
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result.results.mapToUserList())
            }
        }
        return Resource.Error(response.message())
    }
}
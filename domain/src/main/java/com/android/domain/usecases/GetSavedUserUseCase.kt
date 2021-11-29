package com.android.domain.usecases

import com.android.domain.models.UserModel
import com.android.domain.repositories.UserRepository
import kotlinx.coroutines.flow.Flow

class GetSavedUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(): Flow<List<UserModel>> {
        return userRepository.getSavedUser()
    }
}
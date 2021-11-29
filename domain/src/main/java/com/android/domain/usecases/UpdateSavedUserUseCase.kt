package com.android.domain.usecases

import com.android.domain.models.UserModel
import com.android.domain.repositories.UserRepository

class UpdateSavedUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(id: Int, status: String) = userRepository.updateSavedUser(id, status)
}
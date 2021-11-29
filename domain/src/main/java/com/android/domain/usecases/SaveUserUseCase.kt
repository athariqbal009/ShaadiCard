package com.android.domain.usecases

import com.android.domain.models.UserModel
import com.android.domain.repositories.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(userModel: List<UserModel>) = userRepository.saveUserDetails(userModel)
}
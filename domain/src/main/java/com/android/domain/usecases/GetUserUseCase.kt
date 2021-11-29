package com.android.domain.usecases

import com.android.domain.models.UserModel
import com.android.domain.repositories.UserRepository
import com.android.domain.utils.Resource

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(): Resource<List<UserModel>> {
        return userRepository.getUserDetails()
    }
}
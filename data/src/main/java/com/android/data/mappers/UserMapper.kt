package com.android.data.mappers

import com.android.data.local.entity.UserEntity
import com.android.data.remote.models.Result
import com.android.domain.models.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun List<Result>.mapToUserList(): List<UserModel> {
    return this.map { it.mapToUserModel() }
}

fun Result.mapToUserModel(): UserModel {
    return UserModel(
        imageUrl = picture.medium,
        fullName = name.title.plus(". ").plus(name.first).plus(" ").plus(name.last),
        age = dob.age,
        city = location.city,
        state = location.state,
        country = location.country,
        address = location.city.plus(", ").plus(location.state).plus(", ").plus(location.country)
    )
}

fun List<UserModel>.mapToUserEntityList(): List<UserEntity> {
    return this.map { it.mapToUserEntityModel() }
}

fun UserModel.mapToUserEntityModel(): UserEntity {
    return UserEntity(
        id = id,
        name = fullName,
        age = age,
        address = address,
        url = imageUrl,
        status = status
    )
}

fun Flow<List<UserEntity>>.mapToUserModelList(): Flow<List<UserModel>> {
    return this.map { it.mapToUserModelList() }
}

fun List<UserEntity>.mapToUserModelList(): List<UserModel> {
    return this.map { it.mapToUserModel() }
}

fun UserEntity.mapToUserModel(): UserModel {
    return UserModel(
        id = id,
        imageUrl = url,
        fullName = name,
        age = age,
        address = address,
        status = status
    )
}
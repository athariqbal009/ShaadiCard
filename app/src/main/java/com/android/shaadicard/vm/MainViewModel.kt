package com.android.shaadicard.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.android.domain.models.UserModel
import com.android.domain.usecases.GetSavedUserUseCase
import com.android.domain.usecases.GetUserUseCase
import com.android.domain.usecases.SaveUserUseCase
import com.android.domain.usecases.UpdateSavedUserUseCase
import com.android.domain.utils.Resource
import com.android.shaadicard.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val app: Application,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val getSavedUserUseCase: GetSavedUserUseCase,
    private val updateSavedUserUseCase: UpdateSavedUserUseCase
) : AndroidViewModel(app) {
    init {
        getUser()
    }

    private fun getUser() = viewModelScope.launch(Dispatchers.IO) {
        if (Utils.isNetworkAvailable(app)) {
            when (val users = getUserUseCase.execute()) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    users.data?.let {
                        Timber.d(it.toString())
                        saveUserUseCase.execute(it)
                    }
                }
                is Resource.Error -> {

                }
            }
        }
    }

    fun getSavedUsers() = liveData {
        getSavedUserUseCase.execute().collect {
            emit(it)
        }
    }

    fun updateUser(id: Int, status: String) = viewModelScope.launch(Dispatchers.IO) {
        updateSavedUserUseCase.execute(id, status)
    }
}
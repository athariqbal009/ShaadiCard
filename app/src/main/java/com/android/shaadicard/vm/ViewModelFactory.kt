package com.android.shaadicard.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.domain.usecases.GetSavedUserUseCase
import com.android.domain.usecases.GetUserUseCase
import com.android.domain.usecases.SaveUserUseCase
import com.android.domain.usecases.UpdateSavedUserUseCase

class ViewModelFactory (
    private val app: Application,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val getSavedUserUseCase: GetSavedUserUseCase,
    private val updateSavedUserUseCase: UpdateSavedUserUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            app,
            getUserUseCase,
            saveUserUseCase,
            getSavedUserUseCase,
            updateSavedUserUseCase
        ) as T
    }
}
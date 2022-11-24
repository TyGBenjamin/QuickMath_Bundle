package com.example.quickmath.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmath.repo.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Math view model
 *
 * @property repo
 * @constructor Create empty Math view model
 */
@HiltViewModel
class MathViewModel @Inject constructor(private val repo: RepositoryImpl): ViewModel() {
    private val _result = MutableStateFlow("")
    val result: StateFlow<String> get() = _result

    suspend fun evaluateExpression(expr: String) {
        viewModelScope.launch {
            _result.value = repo.evaluateExpression(expr)
            println("THIS IS VALUE OF FLOW ${repo.evaluateExpression(expr)}")
        }
    }
}


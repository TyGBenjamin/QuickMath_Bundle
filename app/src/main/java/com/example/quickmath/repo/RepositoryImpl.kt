package com.example.quickmath.repo

import com.example.quickmath.remote.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun evaluateExpression(expr: String): String {
        return apiService.evaluateExpression(expr)
    }
}


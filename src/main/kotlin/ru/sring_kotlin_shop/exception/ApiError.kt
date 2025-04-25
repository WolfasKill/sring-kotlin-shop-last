package ru.sring_kotlin_shop.exception

data class ApiError(
    val errorCode: String, // not.found
    val description: String,
)

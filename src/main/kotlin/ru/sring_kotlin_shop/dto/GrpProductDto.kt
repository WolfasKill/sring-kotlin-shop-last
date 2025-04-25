package ru.sring_kotlin_shop.dto

data class GrpProductDto(
    val id: Int? = null,
    val name: String,
    val product: List<ProductDto>,
)

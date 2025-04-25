package ru.sring_kotlin_shop.service

import ru.sring_kotlin_shop.dto.GrpProductDto

interface GrpProductService {

    fun getAll(pageIndex: Int): List<GrpProductDto>

    fun getById(id: Int): GrpProductDto

    fun search(prefix: String): List<GrpProductDto>

    fun getgrproductNames(): List<String>

    fun create(dto: GrpProductDto): Int

    fun update(id: Int, dto: GrpProductDto)

    fun delete(id: Int)
}
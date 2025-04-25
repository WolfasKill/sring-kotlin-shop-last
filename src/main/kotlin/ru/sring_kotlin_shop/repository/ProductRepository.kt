package ru.sring_kotlin_shop.repository

import org.springframework.data.repository.CrudRepository
import ru.sring_kotlin_shop.entity.GrpProductEntity
import ru.sring_kotlin_shop.entity.ProductEntity

interface ProductRepository: CrudRepository<ProductEntity, Int> {

    fun deleteAllByGrpproduct(product: GrpProductEntity)
}
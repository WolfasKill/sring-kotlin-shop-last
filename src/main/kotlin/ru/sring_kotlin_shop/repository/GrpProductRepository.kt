package ru.sring_kotlin_shop.repository

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository
import ru.sring_kotlin_shop.entity.GrpProductEntity
import ru.sring_kotlin_shop.model.NameOnly

interface GrpProductRepository : CrudRepository<GrpProductEntity, Int> {

    fun findByOrderByName(pageable: PageRequest): List<GrpProductEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<GrpProductEntity>

    fun findAllByOrderByName(): List<NameOnly>
}
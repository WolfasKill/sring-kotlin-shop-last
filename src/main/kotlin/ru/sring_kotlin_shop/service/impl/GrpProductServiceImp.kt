package ru.sring_kotlin_shop.service.impl

import jakarta.transaction.Transactional
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.sring_kotlin_shop.dto.GrpProductDto
import ru.sring_kotlin_shop.dto.ProductDto
import ru.sring_kotlin_shop.entity.GrpProductEntity
import ru.sring_kotlin_shop.entity.ProductEntity
import ru.sring_kotlin_shop.exception.GrpProductyNotFoundException
import ru.sring_kotlin_shop.repository.GrpProductRepository
import ru.sring_kotlin_shop.repository.ProductRepository
import ru.sring_kotlin_shop.service.GrpProductService

@Service
class GrpProductServiceImp(
    private val countryRepository: GrpProductRepository,
    private val cityRepository: ProductRepository,
) : GrpProductService {

    override fun getAll(pageIndex: Int): List<GrpProductDto> =
        countryRepository.findByOrderByName(PageRequest.of(pageIndex, 2))
            .map { it.toDto() }

    override fun getById(id: Int): GrpProductDto =
        countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw GrpProductyNotFoundException(id)

    override fun search(prefix: String): List<GrpProductDto> =
        countryRepository.findByNameStartsWithIgnoreCaseOrderByName(prefix)
            .map { it.toDto() }

    override fun getgrproductNames(): List<String> =
        countryRepository.findAllByOrderByName().map { it.name }

    @Transactional
    override fun create(dto: GrpProductDto): Int {
        val grpProductEntity = countryRepository.save(dto.toEntity())
        val products = dto.product.map { it.toEntity(grpProductEntity) }
        cityRepository.saveAll(products)
        return grpProductEntity.id
    }

    @Transactional
    override fun update(id: Int, dto: GrpProductDto) {
        var existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw GrpProductyNotFoundException(id)

        existingCountry.name = dto.name
//        existingCountry.population = dto.population

        existingCountry = countryRepository.save(existingCountry)

        val products = dto.product.map { it.toEntity(existingCountry) }
        cityRepository.deleteAllByGrpproduct(existingCountry)
        cityRepository.saveAll(products)
    }

    @Transactional
    override fun delete(id: Int) {
        val existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw GrpProductyNotFoundException(id)

        cityRepository.deleteAllByGrpproduct(existingCountry)
        countryRepository.deleteById(existingCountry.id)
    }

    private fun GrpProductEntity.toDto(): GrpProductDto =
        GrpProductDto(
            id = this.id,
            name = this.name,
            product = this.product.map { it.toDto() },
        )

    private fun ProductEntity.toDto(): ProductDto =
        ProductDto(
            name = this.name,
        )

    private fun GrpProductDto.toEntity(): GrpProductEntity =
        GrpProductEntity(
            id = 0,
            name = this.name,
        )

    private fun ProductDto.toEntity(grpproduct: GrpProductEntity): ProductEntity =
        ProductEntity(
            id = 0,
            name = this.name,
            grpproduct = grpproduct,
        )
}
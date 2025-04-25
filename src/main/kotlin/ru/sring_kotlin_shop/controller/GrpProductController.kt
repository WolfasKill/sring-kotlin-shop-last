package ru.sring_kotlin_shop.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.sring_kotlin_shop.dto.GrpProductDto
import ru.sring_kotlin_shop.service.GrpProductService


@RestController
@RequestMapping("/GrpProduct")
class GrpProductController (
    private val grpProductService: GrpProductService,
) {

    @GetMapping
    fun getAll(@RequestParam("page") pageIndex: Int): List<GrpProductDto> =
        grpProductService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): GrpProductDto =
        grpProductService.getById(id)

    @GetMapping("/search")
    fun searchGrpProduct(@RequestParam("prefix") prefix: String): List<GrpProductDto> =
        grpProductService.search(prefix)

    @GetMapping("/names")
    fun getProductName(): List<String> = grpProductService.getgrproductNames()

    @PostMapping
    fun create(@RequestBody dto: GrpProductDto): Int = grpProductService.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: GrpProductDto) {
        grpProductService.update(id, dto)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        grpProductService.delete(id)
    }
}
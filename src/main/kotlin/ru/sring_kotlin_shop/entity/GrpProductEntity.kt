package ru.sring_kotlin_shop.entity

import jakarta.persistence.*


@Entity
@Table(name = "TBL_GRP_PRODUCT")
class GrpProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    @OneToMany(mappedBy = "grpproduct")
    var product: MutableSet<ProductEntity> = HashSet(),

)


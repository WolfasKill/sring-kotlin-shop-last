package ru.sring_kotlin_shop.exception

import org.springframework.http.HttpStatus


class GrpProductyNotFoundException(GrpProductId: Int) : BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = "country.not.found",
        description = "Country not found with id=$GrpProductId"
    )
)
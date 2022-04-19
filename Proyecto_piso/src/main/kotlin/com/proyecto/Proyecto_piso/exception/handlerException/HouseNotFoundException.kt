package com.proyecto.Proyecto_piso.exception.handlerException

import com.proyecto.Proyecto_piso.exception.Constants
import java.lang.RuntimeException

data class HouseNotFoundException(
    val code: String = Constants.HOUSE_NOT_FOUND.code,
    val reason: Constants
) : RuntimeException(reason.message)

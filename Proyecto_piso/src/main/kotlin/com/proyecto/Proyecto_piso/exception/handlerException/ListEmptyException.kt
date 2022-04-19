package com.proyecto.Proyecto_piso.exception.handlerException

import com.proyecto.Proyecto_piso.exception.Constants
import java.lang.RuntimeException

data class ListEmptyException(
    val code: String = Constants.LIST_EMPTY.code,
    val reason: Constants
) : RuntimeException(reason.message)

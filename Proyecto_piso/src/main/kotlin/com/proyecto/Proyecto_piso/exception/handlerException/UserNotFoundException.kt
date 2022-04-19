package com.proyecto.Proyecto_piso.exception.handlerException

import com.proyecto.Proyecto_piso.exception.Constants
import java.lang.RuntimeException

data class UserNotFoundException(
    val code: String = Constants.USER_NOT_FOUND.code,
    val reason: Constants
) : RuntimeException(reason.message)

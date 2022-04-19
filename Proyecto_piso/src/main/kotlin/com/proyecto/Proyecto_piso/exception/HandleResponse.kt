package com.proyecto.Proyecto_piso.exception

import com.fasterxml.jackson.annotation.JsonProperty

data class HandleResponse(
    @JsonProperty("code") val code: String? = null,

    @JsonProperty("errorCode") val errorCode: String? = null,

    @JsonProperty("message") val message: String? = null
)

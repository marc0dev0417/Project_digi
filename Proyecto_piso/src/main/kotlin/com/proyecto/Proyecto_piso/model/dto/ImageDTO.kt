package com.proyecto.Proyecto_piso.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Lob

data class ImageDTO(
    @JsonProperty("idImage") var idImage: Int? = null,

    @JsonProperty("url") var url: String? = null
)


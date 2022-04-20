package com.proyecto.Proyecto_piso.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class HouseDTO(
    @JsonProperty("idHouse") val idHouse: Int? = null,

    @JsonProperty("address") var address: String? = null,

    @JsonProperty("region") var region: String? = null,

    @JsonProperty("price") var price: Double? = null,

    @JsonProperty("description") var description: String? = null,

    @JsonProperty("space") var space: Int? = null,

    @JsonProperty("images") var images: MutableList<ImageDTO>? = mutableListOf()
)

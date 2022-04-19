package com.proyecto.Proyecto_piso.model.dto.filters

import com.fasterxml.jackson.annotation.JsonProperty

data class HouseFilterDTO(
    @JsonProperty("address") val address: String? = null,

    @JsonProperty("price") val price: Double? = null,

    @JsonProperty("priceLimit") val priceLimit: Double? = null
)

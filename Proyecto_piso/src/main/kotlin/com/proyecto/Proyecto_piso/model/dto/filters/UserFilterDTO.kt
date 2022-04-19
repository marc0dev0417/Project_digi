package com.proyecto.Proyecto_piso.model.dto.filters

import com.fasterxml.jackson.annotation.JsonProperty

data class UserFilterDTO(
    @JsonProperty("firstname") val firstname: String? = null,

    @JsonProperty("lastname") val lastname: String? = null,

    @JsonProperty("address") val address: String? = null,

    @JsonProperty("username") val username: String? = null,

    @JsonProperty("mail") val mail: String? = null
)

package com.proyecto.Proyecto_piso.model.dto.pages

import com.fasterxml.jackson.annotation.JsonProperty
import com.proyecto.Proyecto_piso.model.dto.UserDTO

data class UserPageDTO(
    @JsonProperty("content") val content: MutableList<UserDTO>? = mutableListOf(),

    @JsonProperty("totalPages") val totalPages: Int? = null,

    @JsonProperty("totalElements") val totalElements: Long? = null,

    @JsonProperty("last") val last: Boolean? = null,

    @JsonProperty("numberOfElements") val numberOfElements: Int? = null,

    @JsonProperty("first") val first: Boolean? = null,

    @JsonProperty("size") val size: Int? = null,

    @JsonProperty("number") val number: Int? = null,

    @JsonProperty("empty") val empty: Boolean? = null
)

package com.proyecto.Proyecto_piso.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDTO(
    @JsonProperty("idUser") val idUser: Int? = null,

    @JsonProperty("firstname") var firstname: String? = null,

    @JsonProperty("lastname") var lastname: String? = null,

    @JsonProperty("address") var address: String? = null,

    @JsonProperty("username") var username: String? = null,

    @JsonProperty("mail") var mail: String? = null,

    @JsonProperty("password") var password: String? = null,

    @JsonProperty("houses") var houses: MutableList<HouseDTO>? = mutableListOf(),

    @JsonProperty("houseLikes") var houseLikes: MutableList<HouseDTO>? = mutableListOf()

)

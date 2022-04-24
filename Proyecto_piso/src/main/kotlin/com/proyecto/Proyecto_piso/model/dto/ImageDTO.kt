package com.proyecto.Proyecto_piso.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Lob

data class ImageDTO(
    @JsonProperty("idImage") var idImage: Int? = null,

    @Lob
    @JsonProperty("picture") var picture: ByteArray? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageDTO

        if (idImage != other.idImage) return false
        if (picture != null) {
            if (other.picture == null) return false
            if (!picture.contentEquals(other.picture)) return false
        } else if (other.picture != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idImage ?: 0
        result = 31 * result + (picture?.contentHashCode() ?: 0)
        return result
    }
}

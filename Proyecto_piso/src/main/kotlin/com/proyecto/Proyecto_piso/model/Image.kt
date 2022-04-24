package com.proyecto.Proyecto_piso.model

import javax.persistence.*

@Entity
@Table(name = "images")
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idImage: Int? = null,

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picture")
    var picture: ByteArray? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

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

package com.proyecto.Proyecto_piso.model

import javax.persistence.*

@Entity
@Table(name = "images")
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idImage: Int? = null,

   @Column(name = "url", unique = true)
   var url: String? = null
)


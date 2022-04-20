package com.proyecto.Proyecto_piso.model

import javax.persistence.*

@Entity
@Table(name = "houses")
data class House(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idHouse:Int? = null,
    var address:String? = null,
    var region:String? = null,
    var price:Double? = null,
    var description:String? = null,
    var space:Int? = null,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var images: MutableList<Image>? = mutableListOf()

)

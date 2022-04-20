package com.proyecto.Proyecto_piso.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idUser:Int? = null,
    @Column(name = "firstname", nullable = false)
    var firstname:String,
    @Column(name = "lastname", nullable = false)
    var lastname:String,
    @Column(name = "address", nullable = false)
    var address:String,
    @Column(name = "username", nullable = false, unique = true)
    var username:String,
    @Column(name = "mail", nullable = false, unique = true)
    var mail:String,
    @Column(name = "password", nullable = false)
    var password:String,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var houses:MutableList<House>? = mutableListOf(),
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "houseLikes",
        joinColumns = [JoinColumn(name = "idUser")],
        inverseJoinColumns = [JoinColumn(name = "idHouse")]
    )
    var houseLikes: MutableList<House>? = mutableListOf()
)

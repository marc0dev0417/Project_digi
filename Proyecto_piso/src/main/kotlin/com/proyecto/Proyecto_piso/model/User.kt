package com.proyecto.Proyecto_piso.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idUser:Int? = null,
    @Column(name = "firstname", nullable = false)
    var firstName:String,
    @Column(name = "lastname", nullable = false)
    var lastName:String,
    @Column(name = "address", nullable = false)
    var address:String,
    @Column(name = "username", nullable = false, unique = true)
    var userName:String,
    @Column(name = "mail", nullable = false)
    var mail:String,
    @Column(name = "password", nullable = false)
    var password:String,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH, CascadeType.MERGE])
    var listHouses:List<House>? = null,
    @ManyToMany
    @JoinTable(
        name = "user_like_house",
        joinColumns = [JoinColumn(name = "idUser")],
        inverseJoinColumns = [JoinColumn(name = "idHouse")]
    )
    var listHouseLike:List<House>? = null
)

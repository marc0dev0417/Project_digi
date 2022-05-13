package com.proyecto.Proyecto_piso.repository

import com.proyecto.Proyecto_piso.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {
    fun findUserByUsername(username: String): User
}
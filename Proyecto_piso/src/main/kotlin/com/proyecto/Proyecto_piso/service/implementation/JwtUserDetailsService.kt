package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import com.proyecto.Proyecto_piso.model.User as UserApi

@Service
class JwtUserDetailsService(
    val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user: UserApi = userRepository.findUserByUsername(username)
        return User(user.username, user.password, listOf())
    }
}
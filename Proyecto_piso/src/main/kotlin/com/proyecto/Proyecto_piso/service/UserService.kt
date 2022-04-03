package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun findAllUser():List<User>?
    fun findByMail(mail:String):User?
    fun saveUser(user:User):User?
}
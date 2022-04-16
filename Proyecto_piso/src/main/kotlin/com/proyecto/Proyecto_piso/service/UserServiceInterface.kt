package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.User
import org.springframework.stereotype.Service

@Service
interface UserServiceInterface {
    fun findAllUser():List<User>?
    fun findByMail(mail:String):User?
    fun saveUser(user:User):User?
    fun updateUser(id:Int, user:User): User?
}
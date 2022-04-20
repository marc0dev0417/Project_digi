package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import org.springframework.stereotype.Service

@Service
interface UserServiceInterface {
    fun findAllUser():List<UserDTO>?
    fun findByMail(mail:String):UserDTO?
    fun saveUser(userDTO: UserDTO):UserDTO?
    fun updateUser(id:Int, userDTO: UserDTO): UserDTO?
}
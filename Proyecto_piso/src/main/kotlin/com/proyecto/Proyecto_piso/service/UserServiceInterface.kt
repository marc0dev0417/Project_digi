package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
interface UserServiceInterface {
    fun findAllUser():List<UserDTO>?
    fun findUserByUsername(username: String): UserDTO
    fun login(username:String, password: String): ResponseEntity<*>
    fun saveUser(userDTO: UserDTO):UserDTO?
    fun updateUserInHouse(id:Int, houseDTO: HouseDTO): UserDTO?
    fun updateUserById(id: Int, userDTO: UserDTO): ResponseEntity<*>?
    fun getUser(id: Int): UserDTO?
    fun deleteUserHouse(idUser: Int, idHouse: Int): UserDTO?
    fun deleteUser(id: Int): UserDTO?
}
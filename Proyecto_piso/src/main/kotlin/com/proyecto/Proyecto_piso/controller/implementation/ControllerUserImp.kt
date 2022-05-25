package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerUserInterface
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import com.proyecto.Proyecto_piso.service.implementation.UserServiceImp
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerUserImp(
   private val userServiceImp: UserServiceImp

) : ControllerUserInterface {

    override fun findAllUser(): ResponseEntity<List<UserDTO>>? {
        return ResponseEntity.ok(userServiceImp.findAllUser())
    }

    override fun login(username: String, password: String): ResponseEntity<*>? {
        return userServiceImp.login(username, password)
    }

    override fun saveUser(userDTO: UserDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.saveUser(userDTO))
    }

    override fun updateUserById(id: Int, userDTO: UserDTO): ResponseEntity<*>? {
        return ResponseEntity.ok().body(userServiceImp.updateUserById(id, userDTO))
    }

    override fun updateToHouse(id: Int, houseDTO: HouseDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.updateUserInHouse(id, houseDTO))
    }

    override fun getUserByID(id: Int): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.getUser(id))
    }

    override fun deleteHouseUser(idUser: Int, idHouse: Int): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.deleteUserHouse(idUser, idHouse))
    }

    override fun deleteUser(id: Int): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.deleteUser(id))
    }
}

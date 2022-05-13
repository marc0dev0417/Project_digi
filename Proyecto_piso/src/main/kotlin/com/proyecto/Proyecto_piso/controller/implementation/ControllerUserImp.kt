package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerUserInterface
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import com.proyecto.Proyecto_piso.service.implementation.UserServiceImp
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerUserImp(
   private val userServiceImp: UserServiceImp,


) : ControllerUserInterface {

    val logger : Log = LogFactory.getLog(javaClass)

    override fun findAllUser(): ResponseEntity<List<UserDTO>>? {
        return ResponseEntity.ok(userServiceImp.findAllUser())
    }

    override fun login(username: String, password: String): ResponseEntity<*>? {
        return userServiceImp.login(username, password)
    }

    override fun saveUser(userDTO: UserDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.saveUser(userDTO))
    }

    override fun updateToHouse(id: Int, houseDTO: HouseDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.updateUserInHouse(id, houseDTO))
    }

}

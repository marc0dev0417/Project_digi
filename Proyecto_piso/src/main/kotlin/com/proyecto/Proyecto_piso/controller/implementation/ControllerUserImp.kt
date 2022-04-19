package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerUserInterface
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import com.proyecto.Proyecto_piso.service.implementation.UserServiceImp
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerUserImp(
   private val userServiceImp: UserServiceImp
) : ControllerUserInterface {
    override fun findAllUser(): ResponseEntity<List<UserDTO>>? {
        return ResponseEntity.ok(userServiceImp.findAllUser())
    }

    override fun findByMail(mail: String): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.findByMail(mail))
    }

    override fun saveUser(userDTO: UserDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.saveUser(userDTO))
    }

    override fun update(id: Int, userDTO: UserDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.updateUser(id, userDTO))
    }
}
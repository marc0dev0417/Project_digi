package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerUserInterface
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.service.implementation.UserServiceImp
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerUserImp(
   private val userServiceImp: UserServiceImp
) : ControllerUserInterface {
    override fun findAllUser(): ResponseEntity<List<User>>? {
        return ResponseEntity.ok(userServiceImp.findAllUser())
    }

    override fun findByMail(mail: String): ResponseEntity<User>? {
        return ResponseEntity.ok().body(userServiceImp.findByMail(mail))
    }

    override fun saveUser(user: User): ResponseEntity<User>? {
        return ResponseEntity.ok().body(userServiceImp.saveUser(user))
    }

    override fun update(id: Int, user: User): ResponseEntity<User>? {
        return ResponseEntity.ok().body(userServiceImp.updateUser(id, user))
    }
}
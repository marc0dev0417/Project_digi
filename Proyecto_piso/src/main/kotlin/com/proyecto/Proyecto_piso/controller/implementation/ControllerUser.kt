package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerUserInterface
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.service.implementation.UserServiceImp
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerUser(
   private val userServiceImp: UserServiceImp
) : ControllerUserInterface {
    override fun findAllUser(): List<User>? {
        return userServiceImp.findAllUser()
    }

    override fun findByMail(mail: String): User? {
        return userServiceImp.findByMail(mail)
    }

    override fun saveUser(user: User): User? {
        return userServiceImp.saveUser(user)
    }
}
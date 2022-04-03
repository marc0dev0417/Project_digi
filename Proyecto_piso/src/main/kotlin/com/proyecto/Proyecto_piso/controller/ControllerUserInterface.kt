package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.model.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
interface ControllerUserInterface {
    @GetMapping("/users")
    fun findAllUser():List<User>?
    @GetMapping("/users", params = ["mail"])
    fun findByMail(@RequestParam mail:String):User?
    @PostMapping("/users")
    fun saveUser(@RequestBody user:User):User?
}
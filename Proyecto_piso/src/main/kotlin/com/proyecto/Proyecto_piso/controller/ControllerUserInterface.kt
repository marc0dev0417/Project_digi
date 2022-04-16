package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.model.User
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
interface ControllerUserInterface {
    @RequestMapping(
        value = ["/users"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun findAllUser():ResponseEntity<List<User>>?

    @RequestMapping(
        value = ["/users"],
        produces = ["application/json"],
        params = ["mail"],
        method = [RequestMethod.GET]
    )
    fun findByMail(@RequestParam mail:String):ResponseEntity<User>?

    @RequestMapping(
        value = ["/users"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.POST]
    )
    fun saveUser(@RequestBody user:User):ResponseEntity<User>?

    @RequestMapping(
        value = ["/users/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.PUT]
    )
    fun update(@PathVariable id:Int, @RequestBody user:User): ResponseEntity<User>?
}
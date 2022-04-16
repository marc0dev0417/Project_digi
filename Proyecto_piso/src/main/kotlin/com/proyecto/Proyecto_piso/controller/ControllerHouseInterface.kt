package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.model.House
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
interface ControllerHouseInterface {
    @RequestMapping(
        value = ["/houses"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getAllHouse():ResponseEntity<List<House>>?

    @RequestMapping(
        value = ["/houses"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.POST]
    )
    fun saveHouse(@RequestBody house:House):ResponseEntity<House>?
}
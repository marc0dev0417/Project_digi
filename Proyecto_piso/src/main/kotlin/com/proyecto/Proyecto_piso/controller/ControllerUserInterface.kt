package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.exception.HandleResponse
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@Controller
interface ControllerUserInterface {
    @ApiOperation(
        value = "Get all users",
        nickname = "getUsers",
        notes = "You can see users",
        tags = ["User"],
        response = UserDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = UserDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ])
    @RequestMapping(
        value = ["/users"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun findAllUser():ResponseEntity<List<UserDTO>>?

    @ApiOperation(
        value = "Get user by mail",
        nickname = "findByMail",
        notes = "find by mail",
        tags = ["User"],
        response = UserDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = UserDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ])
    @RequestMapping(
        value = ["/users"],
        produces = ["application/json"],
        params = ["mail"],
        method = [RequestMethod.GET]
    )
    fun findByMail(@RequestParam mail:String):ResponseEntity<UserDTO>?

    @RequestMapping(
        value = ["/users"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.POST]
    )
    @ApiOperation(
        value = "save user",
        nickname = "saveUser",
        notes = "save a user",
        tags = ["User"],
        response = UserDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = UserDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ]
    )
    fun saveUser(@RequestBody userDTO: UserDTO):ResponseEntity<UserDTO>?

    @ApiOperation(
        value = "update a user",
        nickname = "updateUser",
        notes = "update a user",
        tags = ["User"],
        response = UserDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = UserDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ]
    )
    @RequestMapping(
        value = ["/users/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.PUT]
    )
    fun update(@PathVariable id:Int, @RequestBody userDTO:UserDTO): ResponseEntity<UserDTO>?
}
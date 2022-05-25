package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.exception.HandleResponse
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


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
        value = "Get user by username and password",
        nickname = "findUserLogin",
        notes = "find by username",
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
        value = ["/login"],
        produces = ["application/json"],
        method = [RequestMethod.GET],
        params = ["username", "password"]
    )
    fun login(@RequestParam(value = "username", required = true) username:String, @RequestParam(value = "password", required = true) password: String):ResponseEntity<*>?

    @RequestMapping(
        value = ["/register"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.POST]
    )
    @ApiOperation(
        value = "save user",
        nickname = "saveUser",
        notes = "save a user",
        tags = ["User"],

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
    @RequestMapping(
        value = ["/users/update/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.PUT]
    )
    @ApiOperation(
        value = "update user by id",
        nickname = "updateUser",
        notes = "update a user",
        tags = ["User"]
        )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = UserDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ]
    )
    fun updateUserById(@PathVariable id: Int, @RequestBody userDTO: UserDTO): ResponseEntity<*>?

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
    fun updateToHouse(@PathVariable id:Int, @RequestBody houseDTO: HouseDTO): ResponseEntity<UserDTO>?
    @ApiOperation(
        value = "get a user",
        nickname = "getUser",
        notes = "get a user",
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
        method = [RequestMethod.GET]
    )
    fun getUserByID(@PathVariable id: Int): ResponseEntity<UserDTO>?
    @ApiOperation(
        value = "delete a user house",
        nickname = "deleteHouseUser",
        notes = "delete a user house",
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
        value = ["/users/delete/house"],
        produces = ["application/json"],
        method = [RequestMethod.DELETE],
        params = ["idUser", "idHouse"]
    )
    fun deleteHouseUser(@RequestParam(value = "idUser", required = true) idUser: Int, @RequestParam(value = "idHouse", required = true) idHouse: Int): ResponseEntity<UserDTO>?
    @ApiOperation(
        value = "delete a user",
        nickname = "deleteUser",
        notes = "delete a user",
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
        value = ["/users/delete/user"],
        produces = ["application/json"],
        method = [RequestMethod.DELETE],
        params = ["idUser"]
    )
    fun deleteUser(@RequestParam(value = "idUser", required = true) id: Int): ResponseEntity<UserDTO>?
}
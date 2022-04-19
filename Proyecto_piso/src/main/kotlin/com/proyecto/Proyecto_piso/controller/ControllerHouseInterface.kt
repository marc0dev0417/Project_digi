package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.exception.HandleResponse
import com.proyecto.Proyecto_piso.model.House
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
interface ControllerHouseInterface {
    @ApiOperation(
        value = "Get all houses",
        nickname = "getHouses",
        notes = "You can see all houses",
        tags = ["House"],
        response = HouseDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "House", response = HouseDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ])
    @RequestMapping(
        value = ["/houses"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    fun getAllHouse():ResponseEntity<List<HouseDTO>>?

    @ApiOperation(
        value = "save a house",
        nickname = "saveHouse",
        notes = "save a house",
        tags = ["House"],
        response = UserDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "House", response = HouseDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ])
    @RequestMapping(
        value = ["/houses"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.POST]
    )
    fun saveHouse(@RequestBody houseDTO:HouseDTO):ResponseEntity<HouseDTO>?
}
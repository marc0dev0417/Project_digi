package com.proyecto.Proyecto_piso.controller

import com.proyecto.Proyecto_piso.exception.HandleResponse
import com.proyecto.Proyecto_piso.model.dto.ImageDTO
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
interface ControllerImageInterface {

    @RequestMapping(
        value = ["/images"],
        produces = ["application/json"],
        consumes = ["application/json"],
        method = [RequestMethod.POST]
    )
    @ApiOperation(
        value = "save image",
        nickname = "saveImage",
        notes = "save an image",
        tags = ["Image"],
        response = ImageDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = ImageDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ])
    fun saveImage(@RequestBody imageDto:ImageDTO): ResponseEntity<ImageDTO>

    @RequestMapping(
        value = ["/images"],
        produces = ["application/json"],
        method = [RequestMethod.GET]
    )
    @ApiOperation(
        value = "get all images",
        nickname = "getImages",
        notes = "get images",
        tags = ["Image"],
        response = ImageDTO::class
    )
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "User", response = ImageDTO::class),
        ApiResponse(code = 400, message = "Bad Request", response = HandleResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = HandleResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = HandleResponse::class),
        ApiResponse(code = 500, message = "Server error", response = HandleResponse::class)
    ])
    fun getImages():ResponseEntity<List<ImageDTO>>
}
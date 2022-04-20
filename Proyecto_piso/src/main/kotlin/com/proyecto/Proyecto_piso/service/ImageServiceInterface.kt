package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.dto.ImageDTO
import org.springframework.stereotype.Service

@Service
interface ImageServiceInterface {
    fun saveImage(imageDTO: ImageDTO):ImageDTO?
    fun findAll():List<ImageDTO>?
}
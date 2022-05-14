package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerImageInterface
import com.proyecto.Proyecto_piso.model.dto.ImageDTO
import com.proyecto.Proyecto_piso.service.implementation.ImageServiceImp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller

@Controller
class ControllerImageImp(
    @Autowired
    val imageService: ImageServiceImp
) : ControllerImageInterface{

    override fun saveImage(imageDto: ImageDTO): ResponseEntity<ImageDTO> {
        return ResponseEntity.ok().body(imageService.saveImage(imageDto))
    }

    override fun getImages(): ResponseEntity<List<ImageDTO>> {
        return ResponseEntity.ok().body(imageService.findAll())
    }
}
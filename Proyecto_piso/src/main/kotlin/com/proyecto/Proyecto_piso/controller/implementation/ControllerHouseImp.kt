package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerHouseInterface
import com.proyecto.Proyecto_piso.model.House
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.service.implementation.HouseServiceImp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller

@Controller
class ControllerHouseImp(
    @Autowired
    val houseService: HouseServiceImp
) : ControllerHouseInterface{

    override fun getAllHouse(): ResponseEntity<List<HouseDTO>>? {
            return ResponseEntity.ok().body(houseService.findAllHouse())
    }

    override fun saveHouse(houseDTO: HouseDTO): ResponseEntity<HouseDTO>? {
        return ResponseEntity.ok().body(houseService.saveHouse(houseDTO))
    }
}
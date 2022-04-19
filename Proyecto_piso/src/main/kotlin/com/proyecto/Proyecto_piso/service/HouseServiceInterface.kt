package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.House
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import org.springframework.stereotype.Service

@Service
interface HouseServiceInterface {
    fun findAllHouse():List<HouseDTO>?
    fun saveHouse(houseDTO: HouseDTO):HouseDTO?
}
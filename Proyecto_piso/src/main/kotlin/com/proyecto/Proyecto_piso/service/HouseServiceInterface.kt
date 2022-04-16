package com.proyecto.Proyecto_piso.service

import com.proyecto.Proyecto_piso.model.House
import org.springframework.stereotype.Service

@Service
interface HouseServiceInterface {
    fun findAllHouse():List<House>?
    fun saveHouse(house:House):House?
}
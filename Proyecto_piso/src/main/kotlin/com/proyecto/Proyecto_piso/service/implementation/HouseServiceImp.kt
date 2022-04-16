package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.model.House
import com.proyecto.Proyecto_piso.repository.HouseRepository
import com.proyecto.Proyecto_piso.service.HouseServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HouseServiceImp(
    @Autowired
    val houseRepository: HouseRepository
): HouseServiceInterface {
    override fun findAllHouse(): List<House>? {
            return houseRepository.findAll().toList()
    }

    override fun saveHouse(house: House): House? {
        return houseRepository.save(house)
    }
}
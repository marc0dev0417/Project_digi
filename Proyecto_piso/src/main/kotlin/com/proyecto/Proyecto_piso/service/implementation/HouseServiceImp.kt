package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.exception.Constants
import com.proyecto.Proyecto_piso.exception.handlerException.ListEmptyException
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.repository.HouseRepository
import com.proyecto.Proyecto_piso.service.HouseServiceInterface
import com.proyecto.Proyecto_piso.util.DataConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HouseServiceImp(
    @Autowired
    val houseRepository: HouseRepository
): HouseServiceInterface {

    override fun findAllHouse(): List<HouseDTO>? {
        if(houseRepository.findAll().isEmpty()){
          throw ListEmptyException(Constants.LIST_EMPTY.code, Constants.LIST_EMPTY)
        }
            return houseRepository.findAll().map { DataConverter.houseToDTO(it) }
    }

    override fun saveHouse(houseDTO: HouseDTO): HouseDTO? {

        val itemToSave = DataConverter.houseFromDTO(houseDTO)
        val itemDb = houseRepository.save(itemToSave)

        return DataConverter.houseToDTO(itemDb)
    }
}
package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.exception.Constants
import com.proyecto.Proyecto_piso.exception.handlerException.ListEmptyException
import com.proyecto.Proyecto_piso.model.dto.ImageDTO
import com.proyecto.Proyecto_piso.repository.ImageRepository
import com.proyecto.Proyecto_piso.service.ImageServiceInterface
import com.proyecto.Proyecto_piso.util.DataConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ImageServiceImp(
    @Autowired
    val imageRepository: ImageRepository
) : ImageServiceInterface{
    override fun saveImage(imageDTO: ImageDTO): ImageDTO? {
        val itemToSave = DataConverter.imageFromDTO(imageDTO)
        val itemDb = imageRepository.save(itemToSave)

        return DataConverter.imageToDTO(itemDb)
    }

    override fun findAll(): List<ImageDTO>? {

        if(imageRepository.findAll().isEmpty()){
            throw ListEmptyException(Constants.LIST_EMPTY.code, Constants.LIST_EMPTY)
        }
        return imageRepository.findAll().map { DataConverter.imageToDTO(it) }
    }
}
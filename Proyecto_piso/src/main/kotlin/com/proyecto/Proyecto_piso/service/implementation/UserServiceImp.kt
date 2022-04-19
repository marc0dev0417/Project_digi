package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.exception.Constants
import com.proyecto.Proyecto_piso.exception.handlerException.ListEmptyException
import com.proyecto.Proyecto_piso.exception.handlerException.UserNotFoundException
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import com.proyecto.Proyecto_piso.repository.UserRepository
import com.proyecto.Proyecto_piso.service.UserServiceInterface
import com.proyecto.Proyecto_piso.util.DataConverter
import org.springframework.stereotype.Service

@Service
class UserServiceImp(
    var userRepository: UserRepository
) : UserServiceInterface {

    override fun findAllUser(): List<UserDTO>? {
        if(userRepository.findAll().isEmpty()){
            throw ListEmptyException(Constants.LIST_EMPTY.code, Constants.LIST_EMPTY)
        }

        return userRepository.findAll().map { DataConverter.userToDTO(it) }
    }

    override fun findByMail(mail: String): UserDTO? {
        if(userRepository.findByMail(mail) == null){
            throw UserNotFoundException(Constants.USER_NOT_FOUND.code, Constants.USER_NOT_FOUND)
        }
        return userRepository.findByMail(mail)
    }

    override fun saveUser(userDTO: UserDTO): UserDTO? {

        val itemToSave = DataConverter.userFromDTO(userDTO)
        val itemDb = userRepository.save(itemToSave)

        return DataConverter.userToDTO(itemDb)
    }

    @Throws(Exception::class)
    override fun updateUser(id: Int, userDTO: UserDTO): UserDTO? {

        return if(userRepository.existsById(id)){
            val itemToSave = DataConverter.userFromDTO(userDTO)
            val itemDb = userRepository.save(itemToSave)

            DataConverter.userToDTO(itemDb)
        }else{
            throw UserNotFoundException(Constants.USER_NOT_FOUND.code, Constants.USER_NOT_FOUND)
        }
    }
}
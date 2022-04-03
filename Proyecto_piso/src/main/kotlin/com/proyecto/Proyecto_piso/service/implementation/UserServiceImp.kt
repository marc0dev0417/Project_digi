package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.repository.UserRepository
import com.proyecto.Proyecto_piso.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImp(
    var userRepository: UserRepository
) : UserService {

    override fun findAllUser(): List<User>? {
        return userRepository.findAll().toList()
    }

    override fun findByMail(mail: String): User? {
        return userRepository.findByMail(mail)
    }

    override fun saveUser(user: User): User? {
        return userRepository.save(user)
    }
}
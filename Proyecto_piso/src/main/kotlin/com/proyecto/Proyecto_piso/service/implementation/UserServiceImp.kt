package com.proyecto.Proyecto_piso.service.implementation

import com.proyecto.Proyecto_piso.exception.Constants
import com.proyecto.Proyecto_piso.exception.handlerException.ListEmptyException
import com.proyecto.Proyecto_piso.exception.handlerException.UserNotFoundException
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import com.proyecto.Proyecto_piso.repository.UserRepository
import com.proyecto.Proyecto_piso.security.JwtTokenUtil
import com.proyecto.Proyecto_piso.service.UserServiceInterface
import com.proyecto.Proyecto_piso.util.DataConverter
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImp(
    var userRepository: UserRepository,
    val authenticationManager: AuthenticationManager,
    val userDetailsService: JwtUserDetailsService,
    val jwtTokenUtil: JwtTokenUtil
) : UserServiceInterface {

    override fun findAllUser(): List<UserDTO>? {
        if(userRepository.findAll().isEmpty()){
            throw ListEmptyException(Constants.LIST_EMPTY.code, Constants.LIST_EMPTY)
        }

        return userRepository.findAll().map { DataConverter.userToDTO(it) }
    }

    override fun findUserByUsername(username: String): UserDTO {

        val user = userRepository.findUserByUsername(username)

        return DataConverter.userToDTO(user)
    }

    override fun login(username: String, password: String): ResponseEntity<*> {

        val responseMap: MutableMap<String, Any> = mutableMapOf()
        val user = userRepository.findUserByUsername(username)
        println(password)
        println(user.toString())
        val valid = BCryptPasswordEncoder().matches(password,  user.password)
        try {
            val auth: Authentication =
                    authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username,
                      password))

            if (auth.isAuthenticated) {

                val userDetails: UserDetails = userDetailsService.loadUserByUsername(username)
                val token: String = jwtTokenUtil.generateToken(userDetails) ?: ""
                responseMap["error"] = false
                responseMap["message"] = "Logged In"
                responseMap["token"] = token
                responseMap["token_expired"] = jwtTokenUtil.isTokenExpired(token).toString()
                responseMap["expired_date"] = jwtTokenUtil.getExpirationDateFromToken(token).toString()
                responseMap["user"] = user
                return ResponseEntity.ok(responseMap)

            } else {

                responseMap["error"] = true
                responseMap["message"] = "Invalid Credentials"
                return ResponseEntity.status(401).body(responseMap)

            }

        } catch (e: DisabledException) {
            e.printStackTrace();
            responseMap["error"] = true
            responseMap["message"] = "User is disabled"
            return ResponseEntity.status(500).body(responseMap);
        } catch (e: BadCredentialsException) {

            responseMap["error"] = true
            responseMap["message"] = "Invalid Credentials"
            return ResponseEntity.status(401).body(responseMap);
        } catch (e: Exception) {

            e.printStackTrace();
            responseMap["error"] = true
            responseMap["message"] = "Something went wrong";
            return ResponseEntity.status(500).body(responseMap);

        }


    }

    override fun saveUser(userDTO: UserDTO): UserDTO? {

        val itemToSave = DataConverter.userFromDTO(userDTO)
        itemToSave.password = BCryptPasswordEncoder().encode(userDTO.password)

        val itemDb = userRepository.save(itemToSave)

        return DataConverter.userToDTO(itemDb)
    }

    @Throws(Exception::class)
    override fun updateUserInHouse(id: Int, houseDTO: HouseDTO): UserDTO? {

        return if(userRepository.existsById(id)){
            val user = userRepository.getById(id)

            user.houses?.add(DataConverter.houseFromDTO(houseDTO))

            val itemDb = userRepository.save(user)

            DataConverter.userToDTO(itemDb)
        }else{
            throw UserNotFoundException(Constants.USER_NOT_FOUND.code, Constants.USER_NOT_FOUND)
        }
    }
}
package com.proyecto.Proyecto_piso.controller.implementation

import com.proyecto.Proyecto_piso.controller.ControllerUserInterface
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO
import com.proyecto.Proyecto_piso.repository.UserRepository
import com.proyecto.Proyecto_piso.security.JwtTokenUtil
import com.proyecto.Proyecto_piso.service.implementation.JwtUserDetailsService
import com.proyecto.Proyecto_piso.service.implementation.UserServiceImp
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerUserImp(
   private val userServiceImp: UserServiceImp,
   private val userRepository: UserRepository,
   val authenticationManager: AuthenticationManager,
   val userDetailsService: JwtUserDetailsService,
   val jwtTokenUtil: JwtTokenUtil
) : ControllerUserInterface {

    val logger : Log = LogFactory.getLog(javaClass)

    override fun findAllUser(): ResponseEntity<List<UserDTO>>? {
        return ResponseEntity.ok(userServiceImp.findAllUser())
    }

    override fun findByMail(mail: String): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.findByMail(mail))
    }

    override fun saveUser(userDTO: UserDTO): ResponseEntity<*> {
        val responseMap: MutableMap<String, Any> = mutableMapOf()

        try {
            val testUser = User(null,
                userDTO.firstname,
                userDTO.lastname,
                userDTO.address,
                userDTO.username,
                userDTO.mail,
                BCryptPasswordEncoder().encode(userDTO.password),
                null,
                null)

            userRepository.save(testUser)

            val auth: Authentication =
                authenticationManager.authenticate(UsernamePasswordAuthenticationToken(userDTO.username,
                    userDTO.password))

            if (auth.isAuthenticated) {

                logger.info("Logged In")
                val userDetails: UserDetails = userDetailsService.loadUserByUsername(userDTO.username)
                val token: String = jwtTokenUtil.generateToken(userDetails) ?: ""
                responseMap["error"] = false
                responseMap["message"] = "Logged In"
                responseMap["token"] = token
                responseMap["token_expired"] = jwtTokenUtil.isTokenExpired(token).toString()
                responseMap["expired_date"] = jwtTokenUtil.getExpirationDateFromToken(token).toString()
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
        } catch (e : Exception) {

            e.printStackTrace();
            responseMap["error"] = true
            responseMap["message"] = "Something went wrong";
            return ResponseEntity.status(500).body(responseMap);

        }
    }
    override fun updateToHouse(id: Int, houseDTO: HouseDTO): ResponseEntity<UserDTO>? {
        return ResponseEntity.ok().body(userServiceImp.updateUserInHouse(id, houseDTO))
    }
}
package com.proyecto.Proyecto_piso.util

import com.proyecto.Proyecto_piso.model.House
import com.proyecto.Proyecto_piso.model.User
import com.proyecto.Proyecto_piso.model.dto.HouseDTO
import com.proyecto.Proyecto_piso.model.dto.UserDTO

class DataConverter {
    companion object{
        fun userToDTO(user: User):UserDTO{
            return UserDTO(
                idUser =  user.idUser,
                firstname = user.firstname,
                lastname = user.lastname,
                address = user.address,
                username = user.username,
                mail = user.mail,
                password = user.password,
                houses = user.houses.let { it?.map { house -> houseToDto(house) } }?.toMutableList(),
                houseLikes = user.houseLikes.let { it?.map { houseLikes -> houseToDto(houseLikes)} }?.toMutableList()
            )
        }
        fun userFromDTO(userDTO: UserDTO): User{
            return User(
                idUser =  userDTO.idUser,
                firstname = userDTO.firstname!!,
                lastname = userDTO.lastname!!,
                address = userDTO.address!!,
                username = userDTO.username!!,
                mail = userDTO.mail!!,
                password = userDTO.password!!,
                houses = userDTO.houses.let { it?.map { houseDTO ->  houseFromDTO(houseDTO)} }?.toMutableList(),
                houseLikes = userDTO.houseLikes.let { it?.map { houseDTO -> houseFromDTO(houseDTO) } }?.toMutableList()
            )
        }
        fun houseToDto(house: House): HouseDTO{
            return HouseDTO(
                idHouse = house.idHouse,
                address = house.address,
                region = house.region,
                price = house.price,
                description = house.description,
                space = house.space
            )
        }
        fun houseFromDTO(houseDTO: HouseDTO): House{
            return House(
                idHouse = houseDTO.idHouse,
                address = houseDTO.address,
                region = houseDTO.region,
                price = houseDTO.price,
                description = houseDTO.description,
                space = houseDTO.space
            )
        }

    }
}
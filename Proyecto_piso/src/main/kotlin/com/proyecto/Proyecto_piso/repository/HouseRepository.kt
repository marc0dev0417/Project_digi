package com.proyecto.Proyecto_piso.repository

import com.proyecto.Proyecto_piso.model.House
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HouseRepository: JpaRepository<House, Int>{
}
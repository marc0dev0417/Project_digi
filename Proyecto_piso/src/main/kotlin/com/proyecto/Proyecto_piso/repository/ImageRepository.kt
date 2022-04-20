package com.proyecto.Proyecto_piso.repository

import com.proyecto.Proyecto_piso.model.Image
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository: JpaRepository<Image, Int>{

}
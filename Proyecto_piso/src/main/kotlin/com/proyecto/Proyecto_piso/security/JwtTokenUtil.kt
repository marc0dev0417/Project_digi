package com.proyecto.Proyecto_piso.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.security.Key
import java.util.*

@Component
class JwtTokenUtil : Serializable{
    val JWT_TOKEN_VALIDITY = (24 * 60 * 60).toLong()

    var key: Key = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    fun getAllClaimsFromToken(token: String): Claims{
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).body
    }

    fun getUsernameFromToken(token: String): String?{
        return getAllClaimsFromToken(token).subject
    }

    fun getExpirationDateFromToken(token: String): Date?{
        return getAllClaimsFromToken(token).expiration
    }

    fun isTokenExpired(token: String): Boolean?{
        val expiration = getExpirationDateFromToken(token)
        return expiration?.before(Date())
    }

    fun generateToken(userDetails: UserDetails): String?{
        val claims: Map<String, Any?> = HashMap()

        return Jwts.builder().setClaims(claims).setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            .signWith(key).compact()
    }

    fun validateToken(token: String?, userDetails: UserDetails): Boolean?{
        val username = getUsernameFromToken(token!!)

        return username == userDetails.username && !isTokenExpired(token)!!
    }
}
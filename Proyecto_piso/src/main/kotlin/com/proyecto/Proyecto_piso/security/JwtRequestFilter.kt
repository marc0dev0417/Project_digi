package com.proyecto.Proyecto_piso.security

import com.proyecto.Proyecto_piso.service.implementation.JwtUserDetailsService
import io.jsonwebtoken.ExpiredJwtException
import org.apache.commons.lang3.StringUtils
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(
    val jwtTokenUtil: JwtTokenUtil,
    val jwtUserDetailsService: JwtUserDetailsService
) : OncePerRequestFilter(){
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val requestTokenHeader = request.getHeader("Authorization")
        if (StringUtils.startsWith(requestTokenHeader, "Bearer ")) {
            val jwtToken = requestTokenHeader.substring(7)
            try {
                val username: String = jwtTokenUtil.getUsernameFromToken(jwtToken) ?: ""
                if (StringUtils.isNotEmpty(username)
                    && null == SecurityContextHolder.getContext().authentication) {
                    val userDetails: UserDetails = jwtUserDetailsService.loadUserByUsername(username)
                    if (jwtTokenUtil.validateToken(jwtToken, userDetails) == true) {
                        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.authorities)
                        usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
                    }
                }
            } catch (e: IllegalArgumentException) {
                logger.error("Unable to fetch JWT Token")
            } catch (e: ExpiredJwtException) {
                logger.error("JWT Token is expired")
            } catch (e: Exception) {
                logger.error(e.message)
            }

        } else {
            logger.warn("JWT Token does not begin with Bearer String")
        }
        filterChain.doFilter(request, response)
    }
}
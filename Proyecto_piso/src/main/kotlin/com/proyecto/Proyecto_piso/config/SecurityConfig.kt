package com.proyecto.Proyecto_piso.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.proyecto.Proyecto_piso.security.JwtRequestFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(private val jwtUserDetailsService: UserDetailsService, jwtRequestFilter: JwtRequestFilter) : WebSecurityConfigurerAdapter(){
    private val jwtRequestFilter: JwtRequestFilter

    init {
        this.jwtRequestFilter = jwtRequestFilter
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder){
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(BCryptPasswordEncoder())
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()?.authorizeRequests()?.antMatchers("/register", "/login")
            ?.permitAll()?.anyRequest()?.authenticated()?.and()?.exceptionHandling()
            ?.authenticationEntryPoint{ request: HttpServletRequest?, response: HttpServletResponse, authException: AuthenticationException? ->

                val responseMap: MutableMap<String, Any> = HashMap()
                val mapper = ObjectMapper()
                response.status = 401
                responseMap["error"] = true
                responseMap["message"] = "Unauthorized"
                response.setHeader("content-type", "application/json")
                val responseMsg = mapper.writeValueAsString(responseMap)
                response.writer.write(responseMsg)

            }?.and()?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ?.and()?.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}
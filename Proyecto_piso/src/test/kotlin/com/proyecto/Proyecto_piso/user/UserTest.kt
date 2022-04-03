package com.proyecto.Proyecto_piso.user

import com.google.gson.Gson
import com.proyecto.Proyecto_piso.model.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.Assert

@SpringBootTest
@AutoConfigureMockMvc
class UserTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private var gson:Gson = Gson()
    @Test
    fun findAllUser(){
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            ).andReturn().response.contentAsString

        val listUser:Array<User> = gson.fromJson(result, Array<User>::class.java)

        Assertions.assertEquals(1, listUser.size)
    }
    @Test
    fun saveUser(){

        val user = User(null, "iki97", "Nadal", "calle del mejor", "iki", "iki@gmail.com","123", null, null)

        val objectUser:String = gson.toJson(user, User::class.java)

        val result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectUser)).andReturn().response.contentAsString

        val valueUser:User = gson.fromJson(result, User::class.java)

        Assertions.assertEquals("iki", valueUser.userName)
    }
    @Test
    fun findByMail(){
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .param("mail", "iki@gmail.com")).andExpect(status().isOk)
            .andReturn().response.contentAsString

        val user:User = gson.fromJson(result, User::class.java)

        Assert.isTrue(user.userName == "iki", "error")
    }
}
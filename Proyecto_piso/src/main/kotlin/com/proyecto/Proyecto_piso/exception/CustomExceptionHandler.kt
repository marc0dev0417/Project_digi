package com.proyecto.Proyecto_piso.exception

import com.proyecto.Proyecto_piso.exception.handlerException.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.io.IOException
import java.io.PrintWriter
import java.io.StringWriter
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class CustomExceptionHandler {

    //Exception to code error 402 ->
    @ExceptionHandler(IOException::class)
    fun handleAccessDeniedException(res: HttpServletResponse) {
        res.sendError(HttpStatus.FORBIDDEN.value(), "Access Denied")
    }

    //Exception to code error 500 ->
    @ExceptionHandler(Exception::class)
    fun handleAll(ex: Exception, request: WebRequest): ResponseEntity<Any>{
        val handleMessage = HandleResponse(HttpStatus.INTERNAL_SERVER_ERROR.name, ex.localizedMessage)
        val sw = StringWriter()
        val pw = PrintWriter(sw)

        ex.printStackTrace(pw)

        return ResponseEntity(handleMessage, HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR)
    }


    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<Any>{
        val notFoundEx = ex as? NotFoundException

        val handleMessage = HandleResponse(notFoundEx?.code, notFoundEx?.reason?.code, notFoundEx?.reason?.message)
        return ResponseEntity(handleMessage, HttpHeaders(), HttpStatus.NOT_FOUND)
    }

}
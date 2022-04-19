package com.proyecto.Proyecto_piso.exception

enum class Constants(val code:String, val message:String) {
    OK("", "OK"),
    NOT_FOUND("NOT_FOUND", "ERROR: Content not found"),
    LIST_EMPTY("LIST_EMPTY", "There is not a list"),
    USER_NOT_FOUND("USER_NOT_FOUND", "Not exist the user"),
    HOUSE_NOT_FOUND("HOUSE_NOT_FOUND", "Not exist the house")
}
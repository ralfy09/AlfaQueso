package edu.ucne.alfaqueso.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UsuarioDto(
    @SerializedName("usuarioId")
    val usuarioId: Int,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("password")
    val password: String
)
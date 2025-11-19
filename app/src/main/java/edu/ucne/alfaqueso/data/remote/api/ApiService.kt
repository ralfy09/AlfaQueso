package edu.ucne.alfaqueso.data.remote.api

import edu.ucne.alfaqueso.data.remote.dto.UsuarioDto
import retrofit2.http.GET

interface ApiService {
    @GET("Usuarios")
    suspend fun getUsuarios(): List<UsuarioDto>
}
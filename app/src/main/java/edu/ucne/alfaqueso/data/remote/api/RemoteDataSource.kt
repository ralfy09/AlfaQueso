package edu.ucne.alfaqueso.data.remote.api

import edu.ucne.alfaqueso.data.remote.dto.UsuarioDto

interface RemoteDataSource {
    suspend fun getAllUsuarios(): List<UsuarioDto>
    suspend fun login(userName: String, password: String): UsuarioDto?
}

class RemoteDataSourceImpl(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getAllUsuarios(): List<UsuarioDto> {
        return apiService.getUsuarios()
    }

    override suspend fun login(userName: String, password: String): UsuarioDto? {
        return try {
            val usuarios = apiService.getUsuarios()
            usuarios.find {
                it.userName.trim().equals(userName.trim(), ignoreCase = true) &&
                        it.password.trim() == password.trim()
            }
        } catch (e: Exception) {
            null
        }
    }
}
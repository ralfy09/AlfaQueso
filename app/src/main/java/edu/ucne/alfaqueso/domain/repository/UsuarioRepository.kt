package edu.ucne.alfaqueso.domain.repository

import edu.ucne.alfaqueso.domain.model.Usuario
import kotlinx.coroutines.flow.Flow

interface UsuarioRepository {
    suspend fun login(userName: String, password: String): Flow<Result<Usuario>>
}
package edu.ucne.alfaqueso.data.reporitory

import edu.ucne.alfaqueso.data.maper.toDomain
import edu.ucne.alfaqueso.data.remote.api.RemoteDataSource
import edu.ucne.alfaqueso.domain.model.Usuario
import edu.ucne.alfaqueso.domain.repository.UsuarioRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsuarioRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : UsuarioRepository {

    override suspend fun login(userName: String, password: String): Flow<Result<Usuario>> = flow {
        try {
            val usuarioDto = remoteDataSource.login(userName, password)
            if (usuarioDto != null) {
                emit(Result.success(usuarioDto.toDomain()))
            } else {
                emit(Result.failure(Exception("Usuario o contraseña incorrectos")))
            }
        } catch (e: Exception) {
            emit(Result.failure(Exception("Error de conexión: ${e.message}")))
        }
    }
}
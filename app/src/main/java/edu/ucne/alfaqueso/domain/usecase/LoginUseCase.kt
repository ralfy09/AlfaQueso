package edu.ucne.alfaqueso.domain.usecase

import edu.ucne.alfaqueso.domain.model.Usuario
import edu.ucne.alfaqueso.domain.repository.UsuarioRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val repository: UsuarioRepository
) {
    suspend operator fun invoke(userName: String, password: String): Flow<Result<Usuario>> {
        return repository.login(userName, password)
    }
}
package edu.ucne.alfaqueso.data.maper

import edu.ucne.alfaqueso.data.remote.dto.UsuarioDto
import edu.ucne.alfaqueso.domain.model.Usuario

fun UsuarioDto.toDomain(): Usuario {
    return Usuario(
        id = this.usuarioId,
        userName = this.userName.trim(),
        password = this.password
    )
}
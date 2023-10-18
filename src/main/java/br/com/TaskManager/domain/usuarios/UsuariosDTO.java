package br.com.TaskManager.domain.usuarios;

import jakarta.validation.constraints.NotBlank;

public record UsuariosDTO(

         @NotBlank
         String nome,
         @NotBlank
         String email

) {
}

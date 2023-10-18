package br.com.TaskManager.domain.tarefausuario;


import br.com.TaskManager.domain.tarefas.TarefaDTO;
import br.com.TaskManager.domain.usuarios.UsuariosDTO;
import jakarta.validation.Valid;


public record TarefaUsuarioDTO(
        Long Id,
        @Valid
        TarefaDTO tarefaDTO,
        @Valid
        UsuariosDTO usuariosDTO
) {



}

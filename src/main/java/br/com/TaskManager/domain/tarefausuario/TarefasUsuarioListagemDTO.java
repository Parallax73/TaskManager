package br.com.TaskManager.domain.tarefausuario;

public record TarefasUsuarioListagemDTO(
        Long id,
        Long usuarioId,
        Long tarefaId
) {
    public TarefasUsuarioListagemDTO(TarefasUsuario tarefasUsuario){
        this (
                tarefasUsuario.getId(),
                tarefasUsuario.getUsuarioId(),
                tarefasUsuario.getTarefaId()
        );

    }
}

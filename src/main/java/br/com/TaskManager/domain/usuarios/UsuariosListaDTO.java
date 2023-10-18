package br.com.TaskManager.domain.usuarios;

public record UsuariosListaDTO(
        Long id,
        String nome,
        String email) {

    public UsuariosListaDTO (Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}

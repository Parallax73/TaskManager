package br.com.TaskManager.domain.usuarios;



import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
}

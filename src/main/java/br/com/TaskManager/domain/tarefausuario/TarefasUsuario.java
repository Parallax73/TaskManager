package br.com.TaskManager.domain.tarefausuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "tarefas_usuario")
@Entity(name = "tarefasUsuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TarefasUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;

    private Long tarefaId;


    public TarefasUsuario(long usuarioId, Long tarefaId) {
        this.usuarioId=usuarioId;
        this.tarefaId=tarefaId;
    }
}

package br.com.TaskManager.domain.tarefas;

import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "Tarefas")
@Entity(name = "Tarefa")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "tarefaId")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tarefaId;
    private String nome;
    private String descricao;
    private String ETA;



    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public Tarefa(TarefaDTO dados) {
        this.nome = dados.nome();
        this.status = dados.getStatus();
        this.prioridade = dados.getPrioridade();
        this.ETA = dados.ETA();
        this.descricao = dados.descricao();
    }

    public void atualizar(TarefaAtualizarDTO dados){
        this.ETA=dados.eta();
        this.status=dados.status();
    }
}

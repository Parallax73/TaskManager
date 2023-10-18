package br.com.TaskManager.domain.tarefas;

import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;

public record TarefasListaDTO(
        Long tarefaId,
        String nome,
        Status status,
        Prioridade prioridade,
        String ETA,
        String descricao) {

    public TarefasListaDTO(Tarefa tarefa){
        this (
                tarefa.getTarefaId(),
                tarefa.getNome(),
                tarefa.getStatus(),
                tarefa.getPrioridade(),
                tarefa.getETA(),
                tarefa.getDescricao()
        );
    }
}

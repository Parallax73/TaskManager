package br.com.TaskManager.domain.tarefas;

import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;

public record TarefaAtualizarDTO(
        String eta,
        Status status,
        Prioridade prioridade
) {
}

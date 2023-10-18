package br.com.TaskManager.domain.pojos;

import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;

public interface SelectTarefaByParam {

    String getNome();
    Status getStatus();
    String getETA();
    Prioridade getPrioridade();

    String getDescricao();
}

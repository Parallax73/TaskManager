package br.com.TaskManager.domain.pojos;

import br.com.TaskManager.domain.enums.Status;

public interface SelectQueryList {

    String getNomeTarefa();
    Status getStatus();
    String getETA();
    Long getTarefaId();
    Long getUsuarioId();
    String getNomeUsuario();

}

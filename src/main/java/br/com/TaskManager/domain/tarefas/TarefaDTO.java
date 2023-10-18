package br.com.TaskManager.domain.tarefas;

import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public record TarefaDTO(
        Long id,
        @NotBlank
        String nome,
        @NotNull
        Status status,
        @NotNull
        Prioridade prioridade,
        @NotBlank
                @Pattern(regexp = "\\\\b\\\\d{4}-\\\\d{2}-\\\\d{2}\\\\b")
        String ETA,
        String descricao) {


    public Status getStatus(){
            return status;
        }
    public Prioridade getPrioridade(){
            return prioridade;
        }
    public Long getId(){
        return id;
    }

}

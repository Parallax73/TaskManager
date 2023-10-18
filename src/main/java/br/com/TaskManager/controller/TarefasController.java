package br.com.TaskManager.controller;

import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;
import br.com.TaskManager.domain.pojos.SelectTarefaByParam;
import br.com.TaskManager.domain.tarefas.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Tarefas")
@SecurityRequirement(name = "bearer-key")
public class TarefasController {

    @Autowired
    private TarefasRepository repository;



    @PostMapping("/CriarTarefa")
    @Transactional
    public void criarTarefa(@RequestBody @Valid TarefaDTO dados){
        repository.save(new Tarefa(dados));
    }

    @GetMapping("ListarTarefas")
    public Page<TarefasListaDTO> listar(@PageableDefault(size = 50) Pageable pageable){
        return repository.findAll(pageable).map(TarefasListaDTO::new);
    }

    @PatchMapping("/AtualizarTarefa/{id}")
    @Transactional
    public void atualizarTarefa(@RequestBody @Valid TarefaAtualizarDTO dados, @PathVariable("id") Long id){
        var tarefa = repository.getReferenceById(id);
        tarefa.atualizar(dados);
    }

    @GetMapping("/ListarPorPrioridade/{prio}")
    public Page<SelectTarefaByParam> findByPrioridade(@PageableDefault(size = 50)Pageable pageable,@PathVariable("prio") Prioridade prioridade){
        return repository.findByPrio(pageable,prioridade);
    }
    @GetMapping("/listarPorStatus/{status}")
    public Page<SelectTarefaByParam> listByStatus(@PageableDefault(size = 50)Pageable pageable, @PathVariable Status status) {
        return repository.findAllByStatus(pageable, status);
    }

}

package br.com.TaskManager.controller;

import br.com.TaskManager.domain.pojos.SelectQueryList;
import br.com.TaskManager.domain.tarefas.TarefasRepository;
import br.com.TaskManager.domain.tarefausuario.TarefasUsuario;
import br.com.TaskManager.domain.tarefausuario.TarefasUsuarioListagemDTO;
import br.com.TaskManager.domain.tarefausuario.TarefasUsuarioRepository;
import br.com.TaskManager.domain.usuarios.UsuariosRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("TarefasUsuario")
@SecurityRequirement(name = "bearer-key")
public class TarefasUsuarioController {

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private TarefasRepository tarefasRepository;

    @Autowired
    private TarefasUsuarioRepository tarefasUsuarioRepository;



    @PostMapping("/AdicionarTarefas")
    @Transactional
    public ResponseEntity addTarefa(@RequestParam(value = "usuarioId") Long id,
                                    @RequestParam(value = "tarefaId") Long id2){
        var usuario = repository.getReferenceById(id);
        var tarefa = tarefasRepository.getReferenceById(id2);
        TarefasUsuario task = new TarefasUsuario(usuario.getUsuarioId(), tarefa.getTarefaId());
        tarefasUsuarioRepository.save(task);
        return ResponseEntity.ok(new TarefasUsuarioListagemDTO(task));
    }

    @GetMapping("/ListarTarefas")
    public Page<SelectQueryList> listTarefasUsuarios(@PageableDefault(size = 50)Pageable pageable){
        return tarefasUsuarioRepository.findAllUsersWithPagination(pageable);
    }

    @GetMapping("/ListarPorUsuario/{id}")
    public Page<SelectQueryList> findAllTarefasByUserId(@PageableDefault(size = 50)Pageable pageable, @PathVariable("id") Long id) {
        return tarefasUsuarioRepository.findAllTarefasByUserId(pageable, id);
    }

    @GetMapping("/ListarPorTarefa/{id}")
    public Page<SelectQueryList> findAllUsersByTarefa(@PageableDefault(size = 50)Pageable pageable, @PathVariable("id") Long id) {
        return tarefasUsuarioRepository.findAllUsersByTarefa(pageable, id);
    }

}

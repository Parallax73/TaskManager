package br.com.TaskManager.controller;


import br.com.TaskManager.domain.usuarios.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("Usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuariosRepository repository;


    @PostMapping("/CriarUsuario")
    @Transactional
    public void criarUsuario(@RequestBody @Valid UsuariosDTO dados){
        repository.save(new Usuario(dados));
    }

    @GetMapping("/{id}")
    public ResponseEntity returnByid(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new UsuariosListaDTO(usuario));
    }
    @GetMapping("ListarUsuarios")
    public Page<UsuariosListaDTO> listar(@PageableDefault(size = 50)Pageable pageable){
        return repository.findAll(pageable).map(UsuariosListaDTO::new);
    }

    @PatchMapping("/AtualizarUsuario/{id}")
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid UsuariosAtualizarDTO dados, @PathVariable("id") Long id){
        var tarefa = repository.getReferenceById(id);
        tarefa.atualizar(dados);
    }
}



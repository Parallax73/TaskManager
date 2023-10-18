package br.com.TaskManager.domain.usuarios;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "Usuarios")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "usuarioId")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    private String nome;
    @Email
    private String email;


    public Usuario(UsuariosDTO dados){
        this.nome=dados.nome();
        this.email=dados.email();

    }
    public void atualizar(UsuariosAtualizarDTO dados){
        this.nome= dados.nome();
        this.email=dados.email();
    }


}

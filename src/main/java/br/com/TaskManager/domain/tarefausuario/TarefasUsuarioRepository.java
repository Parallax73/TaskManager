package br.com.TaskManager.domain.tarefausuario;


import br.com.TaskManager.domain.pojos.SelectQueryList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TarefasUsuarioRepository extends JpaRepository<TarefasUsuario,Long> {




    @Query(value = """
            SELECT  t1.tarefa_Id as 'TarefaId' ,t2.nome as 'NomeTarefa' ,t2.status ,t2.ETA,t3.usuario_Id as 'UsuarioId',t3.nome as 'NomeUsuario'
            FROM tarefas_usuario as t1
            LEFT OUTER JOIN Tarefas as t2
            ON t1.tarefa_id = t2.tarefa_id
            LEFT OUTER JOIN Usuarios  as t3
            ON t1.usuario_id = t3.usuario_id""", nativeQuery = true)
    Page<SelectQueryList> findAllUsersWithPagination(Pageable pageable);


    @Query(value = """
            SELECT  t1.tarefa_Id as 'TarefaId' ,t2.nome as 'NomeTarefa' ,t2.status ,t2.ETA,t3.usuario_Id as 'UsuarioId',t3.nome as 'NomeUsuario'
            FROM tarefas_usuario as t1
            LEFT OUTER JOIN Tarefas as t2
            ON t1.tarefa_id = t2.tarefa_id
            LEFT OUTER JOIN Usuarios  as t3
            ON t1.usuario_id = t3.usuario_id
            WHERE t1.usuario_id = :id""", nativeQuery = true)
    Page<SelectQueryList> findAllTarefasByUserId(Pageable pageable,@Param("id") Long id);
    @Query(value = """
            SELECT  t1.tarefa_Id as 'TarefaId' ,t2.nome as 'NomeTarefa' ,t2.status ,t2.ETA,t3.usuario_Id as 'UsuarioId',t3.nome as 'NomeUsuario'
            FROM tarefas_usuario as t1
            LEFT OUTER JOIN Tarefas as t2
            ON t1.tarefa_id = t2.tarefa_id
            LEFT OUTER JOIN Usuarios  as t3
            ON t1.usuario_id = t3.usuario_id
            WHERE t1.tarefa_id = :id""", nativeQuery = true)
    Page<SelectQueryList> findAllUsersByTarefa(Pageable pageable,@Param("id") Long id);
}


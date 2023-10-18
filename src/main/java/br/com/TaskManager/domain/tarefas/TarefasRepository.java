package br.com.TaskManager.domain.tarefas;


import br.com.TaskManager.domain.enums.Prioridade;
import br.com.TaskManager.domain.enums.Status;
import br.com.TaskManager.domain.pojos.SelectTarefaByParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface TarefasRepository extends JpaRepository<Tarefa, Long> {
    @Query(value = """
            SELECT t1.tarefa_id as 'IdTarefa',t1.nome as 'Nome',t1.status as 'Status', t1.eta as 'ETA', t1.prioridade as 'Prioridade', t1.descricao
            FROM Tarefas t1
            WHERE t1.prioridade=:prioridade""", nativeQuery = true )
    Page<SelectTarefaByParam> findByPrio(Pageable pageable, @Param("prioridade") Prioridade prioridade);
    @Query(value = """
            SELECT t1.tarefa_id as 'IdTarefa',t1.nome as 'Nome',t1.status as 'Status', t1.eta as 'ETA', t1.prioridade as 'Prioridade', t1.descricao\s
            FROM Tarefas t1
            WHERE t1.status=:status""", nativeQuery = true )
    Page<SelectTarefaByParam> findAllByStatus(Pageable pageable, @Param("status") Status status);
}

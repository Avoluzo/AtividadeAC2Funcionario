package br.com.atividadeac2.repositories;

import br.com.atividadeac2.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

        @Query("""
                        SELECT p FROM projetos p
                        LEFT JOIN FETCH p.funcionariosDoProjeto
                        WHERE p.id = :id
                        """)
        Projeto findProjetoByIdAndEmployee(@Param("id") Long id);

        @Query("""
                        SELECT p FROM projetos p
                        WHERE p.dataInicio BETWEEN :dataUm AND :dataDois
                        """)
        List<Projeto> findAllProjectsThatStartBetweenDatas(@Param("dataUm") LocalDate dataUm,
                        @Param("dataDois") LocalDate dataDois);
}

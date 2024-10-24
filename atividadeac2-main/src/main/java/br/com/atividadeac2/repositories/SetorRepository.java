package br.com.atividadeac2.repositories;

import br.com.atividadeac2.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    // LEFT JOIN FECTH É USADO POIS, NATURALMENTE OS FUNCIONÁRIOS DO PROJETO NÃO
    // SERIAM CARREGADOS TAMBÉM
    @Query("""
            SELECT s FROM setores s
            LEFT JOIN FETCH s.funcionarios
            """)
    List<Setor> findAllSectorsWithEmployees();
}

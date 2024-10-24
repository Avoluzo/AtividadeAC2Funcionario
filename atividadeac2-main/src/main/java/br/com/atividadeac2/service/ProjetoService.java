package br.com.atividadeac2.service;

import br.com.atividadeac2.dtos.ProjetoDTO;
import br.com.atividadeac2.dtos.queryreqs.ReturnProjectsWithEmployees;
import br.com.atividadeac2.dtos.queryreqs.ReturnProjectsByData;
import java.time.LocalDate;

public interface ProjetoService {

    void vinculaFuncionarioAoProjeto(Long projetoId, Long funcionarioId);

    ReturnProjectsWithEmployees buscaProjetoPorIdEFuncionarios(Long id);

    ReturnProjectsByData buscaProjetosEntreDatas(LocalDate dataUm, LocalDate dataDois);

    void adicionar(ProjetoDTO projetoDTO);

    void ver();

    void atualizar(Long id, String description);

    void deletar(Long id);
}

package br.com.atividadeac2.service;

import br.com.atividadeac2.dtos.FuncionarioDTO;
import br.com.atividadeac2.dtos.queryreqs.ReturnEmployeeProjects;

public interface FuncionarioService {

    ReturnEmployeeProjects getProjectsWithEmployees(Long funcionarioId);

    void add(FuncionarioDTO funcionarioDTO);

    void ver();

    void update(Long id, String name);

    void delete(Long id);

}

package br.com.atividadeac2.service;

import java.util.List;

import br.com.atividadeac2.dtos.FuncionarioDTO;
import br.com.atividadeac2.dtos.SetorDTO;
import br.com.atividadeac2.dtos.queryreqs.ReturnAllSectorsWithEmployees;
import br.com.atividadeac2.models.Setor;

public interface SetorService {

    ReturnAllSectorsWithEmployees buscaSetorMaisFuncionarios();

    void adicionar(SetorDTO setorDTO);

    void ver();

    void atualizar(Long id, String name);

    void deletar(Long id);
}

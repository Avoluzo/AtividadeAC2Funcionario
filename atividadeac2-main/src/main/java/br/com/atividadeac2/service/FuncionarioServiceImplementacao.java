package br.com.atividadeac2.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atividadeac2.dtos.FuncionarioDTO;
import br.com.atividadeac2.dtos.ProjetoDTO;
import br.com.atividadeac2.dtos.queryreqs.ReturnEmployeeProjects;
import br.com.atividadeac2.models.Funcionario;
import br.com.atividadeac2.models.Projeto;
import br.com.atividadeac2.repositories.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioServiceImplementacao implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public ReturnEmployeeProjects getProjectsWithEmployees(Long funcionarioId) {
        List<Projeto> projetos = funcionarioRepository.findProjectsEmployeesWithId(funcionarioId);
        List<ProjetoDTO> projetoDTOList = projetos.stream().map((Projeto p) -> {
            return ProjetoDTO.builder()
                    .description(p.getDescription())
                    .dataInicio(p.getDataInicio())
                    .dataFim(p.getDataFim())
                    .build();
        }).toList();
        return ReturnEmployeeProjects.builder()
                .projetoDTOList(projetoDTOList)
                .build();
    }

    @Transactional
    public void add(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO.name());
        funcionarioRepository.save(funcionario);
    }

    public void ver() {
        List<Funcionario> funci = funcionarioRepository.findAll();
    }

    @Transactional
    public void update(Long id, String name) {
        Funcionario funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.setName(name);
        funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        Funcionario funcionario = funcionarioRepository.getReferenceById(id);
        funcionarioRepository.delete(funcionario);
    }
}

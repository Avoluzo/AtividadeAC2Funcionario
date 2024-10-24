package br.com.atividadeac2.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atividadeac2.dtos.FuncionarioDTO;
import br.com.atividadeac2.dtos.ProjetoDTO;
import br.com.atividadeac2.dtos.queryreqs.ReturnProjectsByData;
import br.com.atividadeac2.dtos.queryreqs.ReturnProjectsWithEmployees;
import br.com.atividadeac2.models.Funcionario;
import br.com.atividadeac2.models.Projeto;
import br.com.atividadeac2.repositories.FuncionarioRepository;
import br.com.atividadeac2.repositories.ProjetoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoServiceImplementacao implements ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public ReturnProjectsWithEmployees buscaProjetoPorIdEFuncionarios(Long id) {
        Projeto projeto = projetoRepository.findProjetoByIdAndEmployee(id);
        ProjetoDTO projetoDTO = ProjetoDTO.builder()
                .description(projeto.getDescription())
                .dataInicio(projeto.getDataInicio())
                .dataFim(projeto.getDataFim())
                .build();
        List<FuncionarioDTO> funcionarioDTOList = projeto.getFuncionariosDoProjeto().stream().map((Funcionario f) -> {
            return FuncionarioDTO.builder()
                    .name(f.getName())
                    .build();
        }).toList();
        return ReturnProjectsWithEmployees.builder()
                .projeto(projetoDTO)
                .funcionarios(funcionarioDTOList)
                .build();
    }

    @Override
    public ReturnProjectsByData buscaProjetosEntreDatas(LocalDate dataUm, LocalDate dataDois) {
        List<Projeto> projetos = projetoRepository.findAllProjectsThatStartBetweenDatas(dataUm, dataDois);
        List<ProjetoDTO> projetoDTOList = projetos.stream().map((Projeto p) -> {
            return ProjetoDTO.builder()
                    .description(p.getDescription())
                    .dataInicio(p.getDataInicio())
                    .dataFim(p.getDataFim())
                    .build();
        }).toList();
        return ReturnProjectsByData.builder()
                .projetoDTOList(projetoDTOList)
                .build();
    }

    @Override
    public void vinculaFuncionarioAoProjeto(Long projetoId, Long funcionarioId) {
        Projeto projeto = projetoRepository.getReferenceById(projetoId);
        Funcionario funcionario = funcionarioRepository.getReferenceById(funcionarioId);
        projeto.setFuncionariosDoProjeto((List<Funcionario>) funcionario);
        projetoRepository.save(projeto);
    }

    @Transactional
    public void adicionar(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto(projetoDTO.description(), projetoDTO.dataInicio(), projetoDTO.dataFim());
        projetoRepository.save(projeto);
    }

    public void ver() {
        List<Projeto> projetos = projetoRepository.findAll();
    }

    @Transactional
    public void atualizar(Long id, String description) {
        Projeto projeto = projetoRepository.getReferenceById(id);
        projeto.setDescription(description);
        projetoRepository.save(projeto);
    }

    public void deletar(Long id) {
        Projeto projeto = projetoRepository.getReferenceById(id);
        projetoRepository.delete(projeto);
    }
}

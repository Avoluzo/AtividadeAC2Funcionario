package br.com.atividadeac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.atividadeac2.dtos.ProjetoDTO;
import br.com.atividadeac2.dtos.queryreqs.GetEmployeesForProjects;
import br.com.atividadeac2.dtos.queryreqs.GetProjectsForData;
import br.com.atividadeac2.dtos.queryreqs.ReturnProjectsByData;
import br.com.atividadeac2.dtos.queryreqs.ReturnProjectsWithEmployees;
import br.com.atividadeac2.service.ProjetoServiceImplementacao;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoServiceImplementacao projetoServiceImpl;

    @GetMapping("/funcionarios")
    public ReturnProjectsWithEmployees buscarProjetoPorId(@RequestBody GetEmployeesForProjects dto) {
        return projetoServiceImpl.buscaProjetoPorIdEFuncionarios(dto.id());
    }

    @GetMapping("/entre-datas")
    public ReturnProjectsByData buscaProjetosEntreDatas(@RequestBody GetProjectsForData dto) {
        return projetoServiceImpl.buscaProjetosEntreDatas(dto.dataInicio(), dto.dataFim());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(ProjetoDTO projetoDTO) {
        projetoServiceImpl.adicionar(projetoDTO);
    }

    @PutMapping()
    public void vincularFuncionario(Long projetoId, Long funcionarioId) {
        projetoServiceImpl.vinculaFuncionarioAoProjeto(projetoId, funcionarioId);
    }
}
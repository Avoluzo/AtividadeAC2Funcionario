package br.com.atividadeac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.atividadeac2.dtos.FuncionarioDTO;
import br.com.atividadeac2.dtos.queryreqs.GetEmployeeProjects;
import br.com.atividadeac2.dtos.queryreqs.ReturnEmployeeProjects;
import br.com.atividadeac2.service.FuncionarioServiceImplementacao;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImplementacao funcionarioServiceImpl;

    @GetMapping()
    public ReturnEmployeeProjects buscarProjetosDoFuncionario(@RequestBody GetEmployeeProjects dto) {
        return funcionarioServiceImpl.getProjectsWithEmployees(dto.id());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(FuncionarioDTO funcionarioDTO) {
        funcionarioServiceImpl.add(funcionarioDTO);
    }
}
package br.com.atividadeac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.atividadeac2.dtos.SetorDTO;
import br.com.atividadeac2.dtos.queryreqs.ReturnAllSectorsWithEmployees;
import br.com.atividadeac2.service.SetorServiceImplementacao;

@RestController
@RequestMapping("/setor")
public class SetorController {

    @Autowired
    private SetorServiceImplementacao setorServiceImpl;

    @GetMapping()
    public ReturnAllSectorsWithEmployees buscaTodosOsSetoresComFuncionarios() {
        return setorServiceImpl.buscaSetorMaisFuncionarios();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(SetorDTO setorDTO) {
        setorServiceImpl.adicionar(setorDTO);
    }
}
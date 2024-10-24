package br.com.atividadeac2.dtos.queryreqs;

import lombok.Builder;

import java.util.List;

import br.com.atividadeac2.dtos.ProjetoDTO;

@Builder
public record ReturnEmployeeProjects(

                List<ProjetoDTO> projetoDTOList) {
}

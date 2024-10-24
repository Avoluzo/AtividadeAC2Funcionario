package br.com.atividadeac2.dtos.queryreqs;

import br.com.atividadeac2.dtos.ProjetoDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record ReturnProjectsByData(
                List<ProjetoDTO> projetoDTOList) {
}

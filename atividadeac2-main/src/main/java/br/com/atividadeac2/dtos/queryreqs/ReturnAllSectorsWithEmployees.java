package br.com.atividadeac2.dtos.queryreqs;

import lombok.Builder;

import java.util.List;

import br.com.atividadeac2.dtos.SetorDTO;

@Builder
public record ReturnAllSectorsWithEmployees(
        List<SetorDTO> setorDTOList) {
}

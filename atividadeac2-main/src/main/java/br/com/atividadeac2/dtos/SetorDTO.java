package br.com.atividadeac2.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record SetorDTO(
        String name,

        List<FuncionarioDTO> funcionarioDTOList
) {
}

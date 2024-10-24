package br.com.atividadeac2.dtos.queryreqs;

import java.time.LocalDate;

public record GetProjectsForData(
                LocalDate dataInicio,
                LocalDate dataFim) {
}

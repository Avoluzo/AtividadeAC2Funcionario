package br.com.atividadeac2.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "projetos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @ManyToMany
    @JoinTable(
            name = "funcionarios_projetos",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    private List<Funcionario> funcionariosDoProjeto;

    public Projeto(String description, LocalDate dataInicio, LocalDate dataFim) {
        this.description = description;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}

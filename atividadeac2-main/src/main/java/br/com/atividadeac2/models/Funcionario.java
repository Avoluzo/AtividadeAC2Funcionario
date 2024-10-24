package br.com.atividadeac2.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "funcionarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @ManyToMany(mappedBy = "funcionariosDoProjeto")
    private List<Projeto> projetosDoFuncionario;

    public Funcionario(String name) {
        this.name = name;
    }
}

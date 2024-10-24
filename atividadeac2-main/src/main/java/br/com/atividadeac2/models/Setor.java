package br.com.atividadeac2.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "setores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionarios;

    public Setor(String name) {
        this.name = name;
    }
}

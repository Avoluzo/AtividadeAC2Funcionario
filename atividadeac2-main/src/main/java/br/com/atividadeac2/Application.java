package br.com.atividadeac2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.atividadeac2.models.Funcionario;
import br.com.atividadeac2.models.Projeto;
import br.com.atividadeac2.models.Setor;
import br.com.atividadeac2.repositories.FuncionarioRepository;
import br.com.atividadeac2.repositories.ProjetoRepository;
import br.com.atividadeac2.repositories.SetorRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner init(
			@Autowired FuncionarioRepository funcionarioRepository,
			@Autowired ProjetoRepository projetoRepository,
			@Autowired SetorRepository setorRepository) {
		return args -> {
			var f1 = new Funcionario("Gabriel");
			var f2 = new Funcionario("Gustavo");
			var f3 = new Funcionario("Giovani");
			var f4 = new Funcionario("Geraldo");
			var f5 = new Funcionario("Gilberto");
			var f6 = new Funcionario("Getúlio");

			var p1 = new Projeto("Projeto 01", LocalDate.of(2024, 8, 28), LocalDate.of(2024, 8, 30));
			var p2 = new Projeto("Projeto 02", LocalDate.of(2024, 8, 28), LocalDate.of(2024, 8, 30));
			var p3 = new Projeto("Projeto 03", LocalDate.of(2024, 8, 28), LocalDate.of(2024, 8, 30));

			var s1 = new Setor("Tecnologia");
			var s2 = new Setor("RH");
			var s3 = new Setor("Finanças");

			setorRepository.saveAll(List.of(s1, s2, s3));

			// DEFININDO OS SETORES DOS FUNCIONÁRIOS
			f1.setSetor(s1);
			f2.setSetor(s1);
			f3.setSetor(s2);
			f4.setSetor(s2);
			f5.setSetor(s3);
			f6.setSetor(s3);

			// DEFININDO OS FUNCIONÁRIOS DE CADA PROJETO
			p1.setFuncionariosDoProjeto(List.of(f1, f2));
			p2.setFuncionariosDoProjeto(List.of(f3, f4));
			p3.setFuncionariosDoProjeto(List.of(f5, f6));

			// SALVANDO FUNCIONÁRIOS, SETORES E PROJETOS NO BANCO DE DADOS
			funcionarioRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6));
			projetoRepository.saveAll(List.of(p1, p2, p3));
		};
	}
}

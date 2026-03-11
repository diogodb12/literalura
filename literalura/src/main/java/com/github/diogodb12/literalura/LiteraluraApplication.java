package com.github.diogodb12.literalura;

import com.github.diogodb12.literalura.modelo.DadosLivro;
import com.github.diogodb12.literalura.modelo.DadosResposta;
import com.github.diogodb12.literalura.servico.ServicoGutendex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ServicoGutendex servico;

	private Scanner leitura = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		exibirMenu();
	}

	private void exibirMenu() throws Exception {

		int opcao = -1;

		while (opcao != 0) {

			System.out.println("""
                    
                    -------- LiterAlura --------
                    
                    1 - Buscar livro pelo título
                    0 - Sair
                    
                    Escolha uma opção:
                    """);

			opcao = leitura.nextInt();
			leitura.nextLine();

			switch (opcao) {

				case 1:
					buscarLivro();
					break;

				case 0:
					System.out.println("Encerrando aplicação...");
					break;

				default:
					System.out.println("Opção inválida.");
			}
		}
	}

	private void buscarLivro() throws Exception {

		System.out.println("Digite o nome do livro:");
		String titulo = leitura.nextLine();

		DadosResposta resposta = servico.buscarLivro(titulo);

		if (resposta.getResultados().isEmpty()) {
			System.out.println("Livro não encontrado.");
		} else {
			DadosLivro livro = resposta.getResultados().get(0);
			System.out.println(livro);
		}
	}
}
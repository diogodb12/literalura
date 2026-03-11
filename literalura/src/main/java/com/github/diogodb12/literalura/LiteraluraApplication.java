package com.github.diogodb12.literalura;

import com.github.diogodb12.literalura.modelo.Autor;
import com.github.diogodb12.literalura.dto.DadosLivro;
import com.github.diogodb12.literalura.modelo.Livro;
import com.github.diogodb12.literalura.repositorio.AutorRepository;
import com.github.diogodb12.literalura.repositorio.LivroRepository;
import com.github.diogodb12.literalura.servico.ServicoGutendex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ServicoGutendex servicoGutendex;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

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
					2 - Listar todos os livros
					3 - Listar livros por idioma
					4 - Listar autores
					5 - Listar autores vivos em determinado ano
					
					0 - Sair
                    """);

			opcao = leitura.nextInt();
			leitura.nextLine();

			switch (opcao) {

				case 1:
					buscarLivro();
					break;

				case 2:
					listarLivros();
					break;

				case 3:
					listarPorIdioma();
					break;

				case 4:
					listarAutores();
					break;

				case 5:
					listarAutoresVivos();
					break;

				case 0:
					System.out.println("Encerrando aplicação...");
					break;

				default:
					System.out.println("Opção inválida");
			}
		}
	}

	private void buscarLivro() throws Exception {

		System.out.println("Digite o título do livro:");
		String titulo = leitura.nextLine();

		Optional<Livro> livroBanco = livroRepository.findByTituloIgnoreCase(titulo);

		if (livroBanco.isPresent()) {
			System.out.println("Livro já existente no banco:");
			System.out.println(livroBanco.get());
			return;
		}

		DadosLivro dados = servicoGutendex.buscarLivro(titulo);

		if (dados == null) {
			System.out.println("Livro não encontrado.");
			return;
		}

		Livro livro = new Livro(dados);

		livroRepository.save(livro);

		System.out.println("Livro salvo:");
		System.out.println(livro);
	}

	private void listarLivros() {

		List<Livro> livros = livroRepository.findAll();

		livros.forEach(System.out::println);
	}

	private void listarPorIdioma() {

		System.out.println("Digite o idioma para busca (ex: en, pt, es):");
		var idioma = leitura.nextLine();

		List<Livro> livros = livroRepository.findByIdioma(idioma);

		if (livros.isEmpty()) {
			System.out.println("Livros não encontrados para o idioma: " + idioma);
		} else {
			livros.forEach(System.out::println);
		}
	}

	private void listarAutores() {

		List<Autor> autores = autorRepository.findAll();

		if (autores.isEmpty()) {
			System.out.println("Nenhum autor encontrado.");
		} else {
			autores.forEach(System.out::println);
		}
	}

	private void listarAutoresVivos() {

		System.out.println("Digite o ano:");
		int ano = leitura.nextInt();
		leitura.nextLine();

		List<Autor> autores =
				autorRepository
						.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(ano, ano);

		if (autores.isEmpty()) {
			System.out.println("Nenhum autor estava vivo nesse ano.");
		} else {
			autores.forEach(System.out::println);
		}
	}


}
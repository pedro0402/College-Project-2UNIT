package sistemaBiblioteca;

import java.util.Scanner;

class SistemaBiblioteca {
	private Biblioteca biblioteca;

	public SistemaBiblioteca() {
		this.biblioteca = new Biblioteca();
		adicionarLivrosIniciais();
	}

	private void adicionarLivrosIniciais() {
		Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling");
		Livro livro2 = new Livro("Cem Anos de Solidão", "Gabriel García Márquez");
		Livro livro3 = new Livro("1984", "George Orwell");
		Livro livro4 = new Livro("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien");
		Livro livro5 = new Livro("Orgulho e Preconceito", "Jane Austen");
		Livro livro6 = new Livro("E assim que acaba", "Coolen Hoover");
		Livro livro7 = new Livro("Os dois morrem no final", "Adam Silvera");

		biblioteca.adicionarLivro(livro1);
		biblioteca.adicionarLivro(livro2);
		biblioteca.adicionarLivro(livro3);
		biblioteca.adicionarLivro(livro4);
		biblioteca.adicionarLivro(livro5);
		biblioteca.adicionarLivro(livro6);
		biblioteca.adicionarLivro(livro7);
	}

	public void exibirMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Biblioteca ===");
		System.out.println("1. Adicionar livro");
		System.out.println("2. Remover livro");
		System.out.println("3. Mostrar livros");
		System.out.println("4. Sair");
		System.out.println("5. Classificar livro");
		System.out.println("6. Mostrar classificação");
		System.out.print("Escolha uma opção: ");

		try {
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro

			switch (opcao) {
			case 1:
				adicionarLivro(scanner);
				break;
			case 2:
				removerLivro(scanner);
				break;
			case 3:
				biblioteca.mostrarLivros();
				break;
			case 4:
				System.out.println("Encerrando o programa.");
				System.exit(0);
				break;
			case 5:
				classificarLivro(scanner);
				break;
			case 6:
				mostrarClassificacao(scanner);
				break;
			default:
				throw new LivroNaoEncontradoException("Opção inválida. Por favor, escolha uma opção válida.");
			}
		} catch (LivroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Digite uma opção válida.");
		}
	}

	private void adicionarLivro(Scanner scanner) {
		System.out.print("Digite o título do livro: ");
		String titulo = scanner.nextLine();
		System.out.print("Digite o nome do autor: ");
		String autor = scanner.nextLine();

		Livro livro = new Livro(titulo, autor);
		biblioteca.adicionarLivro(livro);

		System.out.println("Livro adicionado com sucesso!");
	}

	private void removerLivro(Scanner scanner) {
		System.out.print("Digite o título do livro a ser removido: ");
		String titulo = scanner.nextLine();

		try {
			biblioteca.removerLivro(titulo);
			System.out.println("Livro removido com sucesso!");
		} catch (LivroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
	}

	private void classificarLivro(Scanner scanner) {
		System.out.print("Digite o título do livro a ser classificado: ");
		String titulo = scanner.nextLine();

		Livro livro = biblioteca.buscarLivro(titulo);

		if (livro != null) {
			System.out.print("Digite a classificação (de 1 a 5 estrelas): ");
			int classificacao = scanner.nextInt();
			livro.setClassificacao(classificacao);
			System.out.println("Classificação atribuída ao livro!");
		} else {
			System.out.println("Livro não encontrado na biblioteca.");
		}
	}

	private void mostrarClassificacao(Scanner scanner) {
		System.out.print("Digite o título do livro: ");
		String titulo = scanner.nextLine();

		Livro livro = biblioteca.buscarLivro(titulo);

		if (livro != null) {
			int classificacao = livro.getClassificacao();
			System.out.println("Classificação do livro: " + classificacao + " estrelas");
		} else {
			System.out.println("Livro não encontrado na biblioteca.");
		}
	}

	public static void main(String[] args) {
		SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca();
		while (true) {
			sistemaBiblioteca.exibirMenu();
		}
	}
}
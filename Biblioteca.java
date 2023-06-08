package sistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(String titulo) throws LivroNaoEncontradoException {
        Livro livroRemover = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroRemover = livro;
                break;
            }
        }

        if (livroRemover != null) {
            livros.remove(livroRemover);
        } else {
            throw new LivroNaoEncontradoException("Livro não encontrado na biblioteca.");
        }
    }

    public void mostrarLivros() {
        if (livros.isEmpty()) {
            System.out.println("A biblioteca não possui livros.");
        } else {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("-------------------");
            }
        }
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }}

package sistemaBiblioteca;

class LivroNaoEncontradoException extends Exception {
	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}

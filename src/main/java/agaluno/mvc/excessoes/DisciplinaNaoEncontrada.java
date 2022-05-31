package agaluno.mvc.excessoes;

public class DisciplinaNaoEncontrada extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DisciplinaNaoEncontrada(String msg) {
		super(msg);
	}

}

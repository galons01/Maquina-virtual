package tp.pr1.exceptions;

public class LexicalAnalysisException extends Exception{

	/**
	 * Se lanza cuando se encuentran errores en el parseo
	 * de un programa fuente (falta la l�nea end, por
	 * ejemplo, o una l�nea es incorrecta)
	 */
	private static final long serialVersionUID = 1L;

	public LexicalAnalysisException(){
		super("Excepci�n LexicalAnalysisException: Error en el parseo del codigo fuente");
	}
	
	public LexicalAnalysisException(String mensaje){
		super(mensaje);
	}
	public String toString(){
		return "Excepcion: programa incorrecto en el bytecode ";
	}
}

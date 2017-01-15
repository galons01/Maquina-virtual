package tp.pr1.exceptions;

public class DivByZeroException extends ExecutionErrorException{

	/**
	 * Es la que se lanza cuando se va a dividir la cima
	 * entre la subcima de la pila de operandos, y la
	 * subcima es 0
	 */
	private static final long serialVersionUID = 1L;

	public DivByZeroException(){
		super("Excepción DivByZeroException: division por cero");
	}
	
	public DivByZeroException(String mensaje){
		super(mensaje);
	}
	public String toString(){
		return "Excepcion: dividir por 0";
	}
}

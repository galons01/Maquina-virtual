package tp.pr1.exceptions;

public class ExecutionErrorException extends Exception{

	/**
	 * Se lanza cuando, al ejecutar un bytecode, se
	 * produce una excepción (división por cero,
	 * desapilar de pila vacía, apilar en pila llena)
	 */
	private static final long serialVersionUID = 1L;
	
	public ExecutionErrorException(){
		super("Excepción ExecutionErrorException detectada");
	}
	
	public ExecutionErrorException(String mensaje){
		super(mensaje);
	}
	public String toString() {
		return "Excepcion: error al dividir por cero o por pila llena o vacia" + System.lineSeparator();
	}
}

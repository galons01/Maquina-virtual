package tp.pr1.exceptions;

public class ExecutionErrorException extends Exception{

	/**
	 * Se lanza cuando, al ejecutar un bytecode, se
	 * produce una excepción (división por cero,
	 * desapilar de pila vacía, apilar en pila llena)
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public ExecutionErrorException(){
		super("Excepcion: error al dividir por cero o por pila llena o vacia");
		this.mensaje = "Excepcion: error al dividir por cero o por pila llena o vacia";
	}
	
	public ExecutionErrorException(String mensaje){
		super(mensaje);
		this.mensaje = mensaje;
	}
	public String toString() {
		return mensaje + System.lineSeparator();
	}
}

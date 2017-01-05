package tp.pr1.exceptions;

public class StackException extends ExecutionErrorException{

	/**
	 * Se lanza por dos motivos: cuando se quiere desapilar
	 * de la pila de operandos y est� vac�a (empty stack
	 * exception) y cuando se intenta apilar y est� llena
	 * (stack overflow exception)
	 */
	private static final long serialVersionUID = 1L;
	
	public StackException(){
		super("Excepci�n StackException: anomalia en el tratamiento de la pila");
	}
	
	public StackException(String mensaje){
		super(mensaje);
	}
}

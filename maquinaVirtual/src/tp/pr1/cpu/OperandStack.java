package tp.pr1.cpu;

/**
 * 
 * Representa la pila de operandos y contiene los metodos 
 * necesarios para realizar las operaciones
 *
 */

public class OperandStack {
	private int n;					//tamaño array
	private int contador;
	private int[] stack;
	
	
	public OperandStack(){
		n = 20;
		contador=0;
		stack = new int[n];
	}
	
	public OperandStack(int n){
		this.n = n;
		contador=0;
		stack = new int[n];
	}
	/**
	 * Mira si entra el valor en la pila y si es asi lo inserta
	 * y devuelve true y sino entra devuelve false
	 * @param valor
	 * @return
	 */
	
	boolean Store(int valor){
		boolean entra = contador<n;
		if(entra){
			stack[contador] = valor;
			contador++;
		}
		return entra;
	}
	/**
	 * Saca la cima de la pila y lo elimina de esta misma
	 * @return
	 */
	int Load(){
		int resultado=0;
		resultado = stack[contador-1];
		contador--;
		return resultado;
	}
	/**
	 * mira si la pila esta vacia
	 * @return
	 */
	
	boolean vacia(){
		return contador == 0;
	}
	
	/**
	 * devuelve la cima de la pila
	 * @return
	 */
	int cima(){
		return stack[contador-1];
	}
	/**
	 * vacia la pila
	 */
	
	void vaciarPila(){
		contador = 0;
	}
	
	public String toString() {
		String resp="  Pila: ";
		if (contador==0) resp+=" <vacia>" + System.lineSeparator();
		else {
		 for (int i=0; i<contador; i++) resp=resp+stack[i]+" ";
		 resp+=System.lineSeparator();
		}
		return resp;
	}
	/**
	 * convierte en caracter la cima de la pila
	 * @param valor
	 * @return
	 */
	public char intChar(int valor){
		return (char) valor;
	}
}

package tp.pr1cpu;

public class OperandStack {
	private int n;					//tamaño array
	private int contador;
	private int[] stack;
	
	
	public OperandStack(){
		n = 10;
		contador=0;
		stack = new int[n];
	}
	
	public OperandStack(int n){
		this.n = n;
		contador=0;
		stack = new int[n];
	}
	
	boolean Store(int valor){
		boolean entra = contador<n;
		if(entra){
			stack[contador] = valor;
			contador++;
		}
		/*if(entra){
			if(contador ==0){
				stack[0] = valor;
				contador++;
			}
			else if(contador-1<n) {
				for(int i=contador-1; i>=0; i--){
					stack[i+1] = stack[i];
				}
				stack[0]=valor;
				contador++;
			}
		}
		*/
		return entra;
	}
	
	int Load(){
		int resultado=0;
		resultado = stack[contador-1];
		/*
		for(int i=0; i<contador-1; i++){
			stack[i] = stack[i+1];
		}
		*/
		contador--;
		return resultado;
	}
	
	boolean vacia(){
		return contador == 0;
	}
	
	int cima(){
		return stack[contador-1];
	}
	
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
	public char intChar(int valor){
		return Character.forDigit(valor, 10);
	}
}

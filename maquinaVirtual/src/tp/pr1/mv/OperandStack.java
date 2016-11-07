package tp.pr1.mv;

public class OperandStack {
	private int n;					//tamaño array
	private int contador;
	private int[] stack;
	
	
	public OperandStack(){
		n = 10;
		contador=0;
		stack = new int[n];
	}
	
	void Store(int valor){
		if(contador ==0){
			stack[0] = valor;
			contador++;
		}
		else if(contador-1<n) {
			for(int i=contador-1; i>=0; i--){
				stack[i] = stack[i+1];
			}
			stack[0]=valor;
			contador++;
		}
	}
	
	int Load(){
		int resultado=0;
		resultado = stack[0];
		for(int i=0; i<contador-1; i++){
			stack[i] = stack[i+1];
		}
		contador--;
		return resultado;
	}
	
	boolean vacia(){
		return contador == 0;
	}
	
	int cima(){
		return stack[0];
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
}

package tp.pr1.mv;

public class Memory {
	private Integer[] memory;
	int n;							//tama�o array
	
	public Memory(){	//creacion de memoria por defecto sin parametros.
		n=20;
		memory = new Integer[n];	
	}
	
	public Memory(int n){	//creacion de memoria asignando tama�o n. CAMBIO
		this.n=n;
		memory = new Integer[n];	
	}
	
	public Memory(int n, Memory memoriaAnt){	//ampliacion de memoria. REVISAR
		this.n=n;
		this.memory = new Integer[n];
		this.memory = memoriaAnt.memory;
	}
	
	public void redimensionar(int n){			// CAMBIO alternativa al constructor
		this.n=n;
		Integer[] memoriaAux = memory;
		this.memory = new Integer[n];
		this.memory = memoriaAux;
	}
	
	//destructor de memoria
	public void vaciarMemoria(){
		for(int i = 0; i < n; i++){
			this.memory[i] = null;
		}
	}
	
	public boolean write(int pos, int value){
		boolean resultado = memory[pos]==null || pos<0;
		if(resultado)
			memory[pos]=value;
		return resultado;
	}
	
	public Integer read(int pos){
		return memory[pos];
	}
	
	public String toString(){
		String resp = "  Memoria: ";
		boolean vacio = true;
		for (int i = 0; i < n; i++){
			if(memory[i] != null){
				resp += " [" + i +"]:" + memory[i].intValue();
				vacio = false;
			}
		}
		if(vacio)
			resp += " <vacia>" + System.lineSeparator();
		else
			resp += System.lineSeparator();
		return resp;
	}
}

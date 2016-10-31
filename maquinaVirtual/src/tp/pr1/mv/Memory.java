package tp.pr1.mv;

public class Memory {
	private Integer[] memory;
	int n;							//tamaño array
	
	public Memory(){	//creacion de memoria por defecto sin parametros.
		n=20;
		memory = new Integer[n];	
	}
	
	public Memory(int n){	//creacion de memoria asignando tamaño n. CAMBIO
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
	
	//falta un destructor de memoria?
	
	public boolean write(int pos, int value){
		boolean resultado = memory[pos]==null || pos<0;
		if(resultado)
			memory[pos]=value;
		return resultado;
	}
	
	public Integer read(int pos){
		return memory[pos];
	}
}

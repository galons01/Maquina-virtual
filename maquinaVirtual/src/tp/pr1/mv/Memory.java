package tp.pr1.mv;

public class Memory {
	private Integer[] memory;
	int n;							//tamaño array
	
	public Memory(){	//creacion de memoria por defecto sin parametros.
		n=2;
		memory = new Integer[n];	
	}
	
	public Memory(int n){	//creacion de memoria asignando tamaño n. CAMBIO
		this.n=n;
		memory = new Integer[n];	
	}
	
	public Memory(int n, Memory memoriaAnt){	//ampliacion de memoria. REVISAR
		this.n=2*n;
		this.memory = new Integer[this.n];
		for(int i=0; i<memoriaAnt.getN(); i++){
			this.memory[i] = memoriaAnt.memory[i];
		}
//		this.memory = memoriaAnt.memory;
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
		boolean escribe = pos>=0 && pos<n;		//si entra
		if(escribe)
			memory[pos]=value;
		return escribe;
	}
	
	public Integer read(int pos){
		if(memory[pos]!= null)
			return memory[pos];
		else 
			return null;
	}
	
	public int getN(){
		return n;
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

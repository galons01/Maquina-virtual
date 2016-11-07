package tp.pr1.mv;

public class ByteCodeProgram {
	private ByteCode[] program;
	private int contador;
	private int tamaño;
	
	public ByteCodeProgram (){
		program = new ByteCode[20];				//por defecto el tamaño es 20
		contador = 0;
		this.tamaño = 20;
	}
	
	public ByteCodeProgram (int tamaño){
		this.tamaño = tamaño;
		program = new ByteCode[this.tamaño];	//el tamaño del programa puede ser personalizado
		contador = 0;
	}
	
	// Añade una instruccion.           //revisar, tal vez nunca se use
	public boolean addInstruccion(ByteCode instruccion){
		boolean entraEnElPrograma = contador < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma){
			program[contador] = instruccion;
			contador ++;
		}
		return entraEnElPrograma;
	}
	
	// Añade una instruccion y parseandola.
	public boolean addInstruccion(String linea){
		boolean entraEnElPrograma = contador < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma){
			ByteCode instruccion = ByteCodeParser.parse(linea);
			program[contador] = instruccion;
			contador ++;
		}
		return entraEnElPrograma;
	}
	
	// Añade una instruccion, parseandola y poniendola en una posicion determinada.
	public boolean addInstruccion(String linea, int pos){
		boolean entraEnElPrograma = pos < this.contador;		//comprueba si existe
		if(entraEnElPrograma){
			ByteCode instruccion = ByteCodeParser.parse(linea);
			program[pos] = instruccion;
		}
		return entraEnElPrograma;
	}
	
	public ByteCode devolverInstruccion(int pos){
		ByteCode instruccion = null;
		boolean entraEnElPrograma = pos < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma)
			instruccion = program[pos];
		return instruccion;
	}
	
	// Inicia/ejecuta un programa.
	public void iniciarPrograma(){
		for(int i = 0; i < contador; i++){
			CPU.execute(program[i]);
		}
	}
	
	// Borra todas las instrucciones del programa.
	public void resetProgram(){
		for (int i=0; i<contador; i++){
			program[i] = null;
		}
		contador = 0;
	}
	
	public void mostrarPrograma(){
		for (int i=0; i<contador; i++){
			System.out.println(i + ": " + program[i].getName() + " " + program[i].getParam());
		}
	}
}

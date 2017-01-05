package tp.pr1.mv;

import tp.pr1.inst.Instruction;

public class ParsedProgram {
	/**
	 * Representa el string parseado en instrucciones de SourceProgram. 
	 *
	 */
	private Instruction[] pProgram;
	private int contador;
	private int tamaño;
	
	public ParsedProgram (){
		pProgram = new Instruction[60];
		contador = 0;
		tamaño = 60;
	}
	
	public ParsedProgram (int tamaño){
		this.tamaño = tamaño;
		pProgram = new Instruction[tamaño];
		contador = 0;
	}
	
	/**
	 * Añade una instruccion al codigo.
	 * 
	 * @param ins
	 */
	public void addInstr(Instruction ins){
		boolean entraEnElPrograma = contador < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma){
			pProgram[contador] = ins;
			contador ++;
		}
		else redimensionar();
	}
	
	private void redimensionar(){
		this.tamaño += this.tamaño;
		Instruction[] sProgramAux = new Instruction[this.tamaño];
		for(int i=0; i<tamaño/2;i++){
			sProgramAux[i] = pProgram[i];
		}
		pProgram = sProgramAux;
//			sProgramAux = Arrays.copyOf(sProgram, newLength) Alternativa chuli
	}
	
	public Instruction getInstr(int k){
		return pProgram[k];
	}
	
	public int getSize(){
		return contador;
	}
	
	public void reset(){
		for(int i=0; i<contador;i++){
			pProgram[i] = null;
		}
		contador = 0;
	}
	
	public String textHelp() {
		return "Almacena el codigo fuente parseado en instrucciones.";
	}

	public void addInstruction(Instruction instruction) {
		// TODO Auto-generated method stub
		
	}
}

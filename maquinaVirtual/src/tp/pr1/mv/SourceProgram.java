package tp.pr1.mv;

import tp.pr1.exceptions.ArrayException;

/**
 * Representa el string original captado del fichero origen, aun no esta compilado. 
 *
 */
public class SourceProgram {
	private String[] sProgram;
	private int contador;
	private int tamaño;
	
	public SourceProgram (){
		sProgram = new String[60];
		contador = 0;
		tamaño = 60;
	}
	
	public SourceProgram (int tamaño){
		this.tamaño = tamaño;
		sProgram = new String[tamaño];
		contador = 0;
	}
	
	/**
	 * Añade una instruccion al codigo.
	 * 
	 * @param ins
	 */
	public void addInstr(String ins) throws ArrayException{
		boolean entraEnElPrograma = contador < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma){
			sProgram[contador] = ins;
			contador ++;
		}
		else //redimensionar();
			throw new ArrayException();
	}
	
	/*private void redimensionar(){
		this.tamaño += this.tamaño;
		String[] sProgramAux = new String[this.tamaño];
		for(int i=0; i<tamaño/2;i++){
			sProgramAux[i] = sProgram[i];
		}
		sProgram = sProgramAux;
//		sProgramAux = Arrays.copyOf(sProgram, newLength) Alternativa chuli
	}*/
	
	public String getInstr(int k){
		return sProgram[k];
	}
	
	public int getSize(){
		return contador;
	}
	
	public void reset(){
		for(int i=0; i<contador;i++){
			sProgram[i] = null;
		}
		contador = 0;
	}
	
	public void mostrarPrograma(){
		for (int i=0; i<contador; i++){
			System.out.println(i + ": " + sProgram[i].toString());
		}
		System.out.println("");
	}
	
	public String textHelp() {
		return "Almacena el codigo fuente.";
	}
}

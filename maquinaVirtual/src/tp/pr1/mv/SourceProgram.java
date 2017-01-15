package tp.pr1.mv;

import tp.pr1.exceptions.ArrayException;

/**
 * Representa el string original captado del fichero origen, aun no esta compilado. 
 *
 */
public class SourceProgram {
	private String[] sProgram;
	private int contador;
	private int tama�o;
	
	public SourceProgram (){
		sProgram = new String[60];
		contador = 0;
		tama�o = 60;
	}
	
	public SourceProgram (int tama�o){
		this.tama�o = tama�o;
		sProgram = new String[tama�o];
		contador = 0;
	}
	
	/**
	 * A�ade una instruccion al codigo.
	 * 
	 * @param ins
	 */
	public void addInstr(String ins) throws ArrayException{
		boolean entraEnElPrograma = contador < this.tama�o;		//comprueba si entra en el array
		if(entraEnElPrograma){
			sProgram[contador] = ins;
			contador ++;
		}
		else //redimensionar();
			throw new ArrayException();
	}
	
	/*private void redimensionar(){
		this.tama�o += this.tama�o;
		String[] sProgramAux = new String[this.tama�o];
		for(int i=0; i<tama�o/2;i++){
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

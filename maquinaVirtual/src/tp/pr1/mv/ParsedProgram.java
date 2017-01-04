package tp.pr1.mv;

import tp.pr1.inst.Instruction;

public class ParsedProgram {
	/**
	 * Representa el string parseado en instrucciones de SourceProgram. 
	 *
	 */
	public class SourceProgram {
		private Instruction[] sProgram;
		private int contador;
		private int tama�o;
		
		public SourceProgram (){
			sProgram = new Instruction[60];
			contador = 0;
			tama�o = 60;
		}
		
		public SourceProgram (int tama�o){
			this.tama�o = tama�o;
			sProgram = new Instruction[tama�o];
			contador = 0;
		}
		
		/**
		 * A�ade una instruccion al codigo.
		 * 
		 * @param ins
		 */
		public void addInstr(Instruction ins){
			boolean entraEnElPrograma = contador < this.tama�o;		//comprueba si entra en el array
			if(entraEnElPrograma){
				sProgram[contador] = ins;
				contador ++;
			}
			else redimensionar();
		}
		
		private void redimensionar(){
			this.tama�o += this.tama�o;
			Instruction[] sProgramAux = new Instruction[this.tama�o];
			for(int i=0; i<tama�o/2;i++){
				sProgramAux[i] = sProgram[i];
			}
			sProgram = sProgramAux;
//			sProgramAux = Arrays.copyOf(sProgram, newLength) Alternativa chuli
		}
		
		public Instruction getInstr(int k){
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
		
		public String textHelp() {
			return "Almacena el codigo fuente parseado en instrucciones.";
		}
	}
}

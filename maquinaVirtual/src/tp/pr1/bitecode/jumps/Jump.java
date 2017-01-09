package tp.pr1.bitecode.jumps;

import tp.pr1.bitecode.ByteCode;

public abstract class Jump extends ByteCode{
	protected int n;
	public Jump(int n){
		super();
		this.n = n;
	}
	
	/**
	 * Ejecuta la parte común del parseo de los bytecodes de salto, 
	 * es decir, si el array de strings no tiene dos componentes devuelve null si no, 
	 * parsea con el método abstracto parseJump()
	 * 
	 * @param s
	 */
	public ByteCode parse(String[] s){
		if(s.length == 2){
			try {
				Integer.parseInt(s[1]);
				return parseJump(s[0], Integer.parseInt(s[1]));
			} catch (NumberFormatException nfe){
				return null;
			}
		}
		else
			return null;
	}
	
	protected abstract ByteCode parseJump(String s, int n);
}

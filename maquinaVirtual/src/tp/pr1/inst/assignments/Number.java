package tp.pr1.inst.assignments;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.bitecode.Push;
import tp.pr1.elements.Compiler;

public class Number implements Term{
	
	private int number;
	
	public Number(int num){
		this.number = num;
	}

	/*private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;*/
	
	@Override
	public Term parse(String term){
		try{ 
		 return new Number(Integer.parseInt(term));
		}
		catch(NumberFormatException e){

			System.out.println("Excepcion: se esperaba un numero");
			System.out.println("Error: asignacion incorrecta");

			return null;
		}
	
	}
	
	@Override
	public ByteCode compile(Compiler compiler) {
		return new Push(number);
	}


}
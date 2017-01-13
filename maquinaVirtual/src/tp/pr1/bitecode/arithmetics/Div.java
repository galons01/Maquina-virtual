package tp.pr1.bitecode.arithmetics;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.elements.CPU;
import tp.pr1.exceptions.DivByZeroException;
import tp.pr1.exceptions.StackException;

public class Div extends Arithmetics{
	
	public Div(){
		super();
	}

	@Override
	protected boolean operates(int c, int sc, CPU cpu) throws DivByZeroException, StackException {
		// TODO Auto-generated method stub
		if(c != 0){
			int res = sc / c;
			if(cpu.push(res))
				return true;
			else 
				return false;
		}
		else
			return false;
	}

	@Override
	protected ByteCode parseOperation(String s) {
		if(s.equalsIgnoreCase("DIV"))
			return new Div();
		else
			return null;
	}
	public String toString(){
		return "DIV ";
	}

}

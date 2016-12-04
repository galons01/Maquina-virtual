package tp.pr1.bitecode.arithmetics;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.cpu.CPU;

public class Mul extends Arithmetics {
	public Mul(){
		super();
	}

	@Override
	protected boolean operates(int c, int sc, CPU cpu) {
		// TODO Auto-generated method stub
		int res = sc * c;
		if(cpu.push(res))
			return true;
		else 
			return false;
	}

	@Override
	protected ByteCode parseOperation(String s) {
		// TODO Auto-generated method stub
		if(s.equalsIgnoreCase("MUL"))
			return new Mul();
		else
			return null;
	}
	public String toString(){
		return "MUL";
	}
}

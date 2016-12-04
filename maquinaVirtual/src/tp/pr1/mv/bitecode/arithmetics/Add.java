package tp.pr1.mv.bitecode.arithmetics;

import tp.pr1.mv.bitecode.ByteCode;
import cpu.CPU;

public class Add extends Arithmetics{
	public Add(){
		super();
	}

	@Override
	protected boolean operates(int c, int sc, CPU cpu) {
			int res = sc + c;
			if(cpu.push(res))
				return true;
			else 
				return false;
	}

	@Override
	protected ByteCode parseOperation(String s) {
		if(s.equalsIgnoreCase("ADD"))
			return new Add();
		else
			return null;
	}
	
	public String toString(){
		return "ADD ";
	}
	
}

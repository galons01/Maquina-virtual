package tp.pr1.bitecode.arithmetics;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.elements.CPU;

public abstract class Arithmetics extends ByteCode{
	private int c;
	private int sc;
	//private ByteCode bc;
	public Arithmetics(){
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		//operates(c, sc, cpu);
		if(!cpu.emptyStack()){
			c = cpu.pop();
			if(!cpu.emptyStack()){
				sc = cpu.pop();
				if(operates(c, sc, cpu))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else{
			return false;
		}
	}
	
	protected abstract boolean operates(int c, int sc, CPU cpu);

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 1)
			return parseOperation(s[0]);
		else
			return null;
	}
	
	protected abstract ByteCode parseOperation(String s);
}

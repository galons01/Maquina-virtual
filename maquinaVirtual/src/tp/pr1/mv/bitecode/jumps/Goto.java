package tp.pr1.mv.bitecode.jumps;

import tp.pr1.mv.bitecode.ByteCode;
import cpu.CPU;

public class Goto extends Jump{
	private int n;

	public Goto(int n) {
		super(n);
		this.n = n;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ByteCode parseJump(String s, int n) {
		// TODO Auto-generated method stub
		
		if(s.equalsIgnoreCase("GOTO")){
			return new Goto(n);
		}
		else
			return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		if(cpu.getProgramCounter() > n){
			cpu.setProgramCounter(n);
			return true;
		}
		else
			return false;
	}
	public String toString(){
		return "GOTO " + n;
	}
}

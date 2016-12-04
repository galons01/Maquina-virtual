package tp.pr1.bitecode.jumps;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.cpu.CPU;

public class IfEq extends ConditionalJumps{
	private int n;
	public IfEq(int n) {
		super(n);
		this.n = n;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		if(c == sc){
			if(!cpu.Termina()){
				cpu.next();
				return true;
			}
			else
				return false;
		}
		else{
			if(cpu.getProgramCounter() > n){
				cpu.setProgramCounter(n);
				return true;
			}
			else
				return false;
		}
	}

	@Override
	protected ByteCode parseJump(String s, int n) {
		// TODO Auto-generated method stub
		if(s.equalsIgnoreCase("IFEQ")){
			return new IfEq(n);
		}
		else
			return null;
	}
	public String toString(){
		return "IFEQ " + n;
	}
}

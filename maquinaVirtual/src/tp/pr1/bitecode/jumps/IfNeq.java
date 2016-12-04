package tp.pr1.bitecode.jumps;

import tp.pr1.bitecode.ByteCode;
import tp.pr1cpu.CPU;

public class IfNeq extends ConditionalJumps {
	private int n;
	public IfNeq(int n) {
		super(n);
		this.n = n;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		// TODO Auto-generated method stub
		if(sc != c){
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
		if(s.equalsIgnoreCase("IFNEQ")){
			return new IfNeq(n);
		}
		else
			return null;
	}
	public String toString(){
		return "IFNEQ " + n;
	}

}

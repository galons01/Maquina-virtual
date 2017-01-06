package tp.pr1.bitecode.jumps;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.elements.CPU;

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
				cpu.setSalto();
				return true;
			}
			else{
				cpu.setSalto();
				return false;
			}
		}
		else{
			if(cpu.getContador() > n){
				cpu.setProgramCounter(n);
				cpu.setSalto();
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

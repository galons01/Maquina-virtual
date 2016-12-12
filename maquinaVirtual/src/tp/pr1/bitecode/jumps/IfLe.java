package tp.pr1.bitecode.jumps;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.cpu.CPU;

public class IfLe extends ConditionalJumps{
	private int n;
	public IfLe(int n) {
		super(n);
		this.n = n;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		// TODO Auto-generated method stub
		if(sc < c){
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
		if(s.equalsIgnoreCase("IFLE")){
			return new IfLe(n);
		}
		else
			return null;
	}
	public String toString(){
		return "IFLE " + n;
	}

}

package tp.pr1.bitecode;

import tp.pr1.cpu.CPU;

public class Store extends ByteCode {
	private int param;
	public Store(int param) {
		super();
		this.param = param;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		if(!cpu.emptyStack()){
			cpu.write(param, cpu.pop());
			return true;
		}
		else
			return false;
	}
	

	@Override
	public ByteCode parse(String[] s) {
		// TODO Auto-generated method stub
		if(s.length>1 && s.length<3 && s[0].equalsIgnoreCase("STORE")){
			try {
				Integer.parseInt(s[1]);
				return new Store(Integer.parseInt(s[1]));
			} catch (NumberFormatException nfe){
				return null;
			}
		}
		else
			return null;
	}
	
	public String toString(){
		return "STORE " + param;
	}

}

package tp.pr1.bitecode;

import tp.pr1cpu.CPU;

public class Load extends ByteCode {
	
	private int param;

	public Load(int param) {
		super();
		this.param = param;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		return cpu.read(param);
	}

	@Override
	public ByteCode parse(String[] s) {
		// TODO Auto-generated method stub
		if(s.length>1 && s.length <3 && s[0].equalsIgnoreCase("LOAD")){
			try {
				Integer.parseInt(s[1]);
				return new Load(Integer.parseInt(s[1]));
			} catch (NumberFormatException nfe){
				return null;
			}
		}
		else
			return null;
	}
	
	public String toString(){
		return "LOAD " + param;
	}

}

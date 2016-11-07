package tp.pr1.mv;

public class ByteCode {
	private int param;
	private ENUM_BYTECODE name;
	
	public ByteCode(ENUM_BYTECODE name, int param){
		this.param=param;
		this.name=name;
	}
	
	public ByteCode(ENUM_BYTECODE name){
		this.name=name;
		this.param = -1;
	}
	
	public ENUM_BYTECODE getName(){
		return this.name;
	}
	
	public int getParam(){
		return this.param;
	}
	public String toString(){
		String resultado;
		if(this.param != -1)
			resultado = name + " " + param;
		else 
			resultado = name + " ";
		return resultado;
	}
}

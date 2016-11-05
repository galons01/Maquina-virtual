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
	}
	
	public ENUM_BYTECODE getName(){
		return this.name;
	}
	
	public int getParam(){
		return this.param;
	}
	public String toString(){
		String resultado;
		resultado = name + " " + param;
		return resultado;
	}
}

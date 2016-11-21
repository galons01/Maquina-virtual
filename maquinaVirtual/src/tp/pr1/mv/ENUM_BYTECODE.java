package tp.pr1.mv;

public enum ENUM_BYTECODE {
	PUSH(1),
	LOAD(1), 
	STORE(1), 
	ADD, 
	SUB, 
	MUL, 
	DIV, 
	OUT, 
	HALT;	
	
	private int nA;
	
	ENUM_BYTECODE(int n) {
		this.nA=n;
	}
	
	ENUM_BYTECODE() {
		this.nA=0;
	}
	
	public int getNA() {
		return this.nA;
	}
}

package tp.pr1.bitecode.jumps;

import tp.pr1.bitecode.ByteCode;

public abstract class Jump extends ByteCode{
	//private int n;
	public Jump(int n){
		super();
		//this.n = n;
	}
	public ByteCode parse(String[] s){
		if(s.length == 2){
			try {
				Integer.parseInt(s[1]);
				return parseJump(s[0], Integer.parseInt(s[1]));
			} catch (NumberFormatException nfe){
				return null;
			}
		}
		else
			return null;
	}
	protected abstract ByteCode parseJump(String s, int n);
}

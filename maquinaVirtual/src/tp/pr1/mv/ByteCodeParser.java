package tp.pr1.mv;

public class ByteCodeParser {
	private static ByteCode byteCode;
	
	
	public static ByteCode parse(String line){
		String[] aux = line.split(" ");
		switch (aux[0]) {
		case "PUSH":  		if(aux.length>1 && aux.length<3){
								try {
									Integer.parseInt(aux[1]);
									byteCode = new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(aux[1]));
								} catch (NumberFormatException nfe){
								}
							}
							else
								byteCode = null;
        					break;
		case "LOAD":  		if(aux.length>1 && aux.length <3){
								try {
									Integer.parseInt(aux[1]);
										byteCode = new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(aux[1]));
								} catch (NumberFormatException nfe){
								}
							}	
							else
								byteCode = null;
							break;
		case "STORE": 	 	if(aux.length>1 && aux.length<3){
								try {
									Integer.parseInt(aux[1]);
									byteCode = new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(aux[1]));
								} catch (NumberFormatException nfe){
								}
							}
							else
								byteCode = null;
							break;
		case "ADD":  		if(aux.length ==1)
								byteCode = new ByteCode(ENUM_BYTECODE.ADD);
							else 
								byteCode = null;
							break;
		case "SUB":  		if(aux.length ==1)
								byteCode = new ByteCode(ENUM_BYTECODE.SUB);
							else 
								byteCode = null;
							break;
		case "MUL": 	 	if(aux.length ==1)
								byteCode = new ByteCode(ENUM_BYTECODE.MUL);
							else
								byteCode = null;
							break;
		case "DIV": 	 	if(aux.length ==1)
								byteCode = new ByteCode(ENUM_BYTECODE.DIV);
							else 
								byteCode = null;
							break;
		case "OUT": 	 	if(aux.length == 1)
								byteCode = new ByteCode(ENUM_BYTECODE.OUT);
							else
								byteCode = null;
							break;
		case "HALT": 	 	if(aux.length == 1)
								byteCode = new ByteCode(ENUM_BYTECODE.HALT);
							else
								byteCode = null;
							break;
		default:		 byteCode = null;
		}
		return byteCode;
	}
}

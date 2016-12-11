package tp.pr1.bitecode;

import tp.pr1.bitecode.arithmetics.Add;
import tp.pr1.bitecode.arithmetics.Div;
import tp.pr1.bitecode.arithmetics.Mul;
import tp.pr1.bitecode.arithmetics.Sub;
import tp.pr1.bitecode.jumps.Goto;
import tp.pr1.bitecode.jumps.IfEq;
import tp.pr1.bitecode.jumps.IfLe;
import tp.pr1.bitecode.jumps.IfLeq;
import tp.pr1.bitecode.jumps.IfNeq;

/**
 * 
 * Parsea Bytecodes, parsea un string que contiene un posible bytecode. 
 * Concretamente dispone de un método public static ByteCode parse(String line) que 
 * devuelve el bytecode almacenado en s o bien null, si s no representa ninguna 
 * instrucción.
 *
 */
public class ByteCodeParser {
	//private static ByteCode byteCode;
	 private final static ByteCode[] bytecodes= {new Add(), new Sub(),  
		 				new Mul(), new Div(),     
		 				new Push(0), new Store(0), 
		 				new Load(0), new Halt(), 
		 				new Out(), new Goto(0),    
		 				new IfEq(0), new IfNeq(0),    
		 				new IfLe(0), new IfLeq(0)};
	
	/**
	 *  Devuelve el bytecode almacenado en s o bien null, si s no representa ninguna instrucción.
	 * @param line
	 * @return
	 */
	public static ByteCode parse(String line){
		line  = line.trim();
		String[] aux = line.split(" +");
		for(int i=0; i<bytecodes.length; i++){
			if(bytecodes[i].parse(aux)!=null){
				return bytecodes[i].parse(aux);
			}
		}
		return null;
	}
	/*	String[] aux = line.split(" ");
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
		*/
}


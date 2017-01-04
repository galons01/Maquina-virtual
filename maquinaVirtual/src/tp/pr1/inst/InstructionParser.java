package tp.pr1.inst;

public class InstructionParser{
	private final static Instruction[] instructions={
			 new SimpleAssignment(), 
			 new CompoundAssignment(),
			 new Write(), 
			 new Return(), 
			 new While(), 
			 new IfThen()};		
}

package tp.pr1.inst.assignments;

/**
 * 
 * 	La clase TermParser parsea los términos que
 *	aparecen en las asignaciones, simples y compuestas,
 *	y en las condiciones del if y del while
 *
 */
public class TermParser {
	private final static Term[] terms =
		{new Variable(""), new Number(0)};
		public static Term parse(String st) {
			Term tm;
			for (Term t:terms) {
			tm=t.parse(st);
			if (tm!=null) return tm;
			}
			return null;
		}
}

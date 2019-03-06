package ch12.annotations;

import java.lang.reflect.*;

class MetaMultiParams {

	// myMeth now has two arguments.
	@MyAnno(str = "Two Parameters", val = 19)
	public static void myMeth(String str, int i) {
		MetaMultiParams ob = new MetaMultiParams();

		try {
			Class<?> c = ob.getClass();
						
			// Update: this might technically be introspection
			// Use reflection to obtain a method that has parameters, you must specify class
			// objects representing the types of those parameters as arguments 
			// to getMethod().
			// Here, the parameter types are specified.
			Method m = c.getMethod("myMeth", String.class, int.class);

			MyAnno anno = m.getAnnotation(MyAnno.class);

			System.out.println(anno.str() + " " + anno.val());
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}

	public static void main(String args[]) {
		myMeth("test", 10);
	}
}
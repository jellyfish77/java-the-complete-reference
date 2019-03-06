package ch12.annotations;

import java.lang.reflect.*;

class Meta3 {

	// Annotate a method using the default values.
	@MyAnno2()
	public static void myMeth() {
		Meta3 ob = new Meta3();

		// Obtain the annotation for this method
		// and display the values of the members.
		try {
			Class<?> c = ob.getClass();

			Method m = c.getMethod("myMeth");

			MyAnno2 anno = m.getAnnotation(MyAnno2.class);

			System.out.println(anno.str() + " " + anno.val());
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}

	public static void main(String args[]) {
		myMeth();
	}
}

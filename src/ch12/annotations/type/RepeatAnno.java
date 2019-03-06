package ch12.annotations.type;

//Demonstrate a repeated annotation.

import java.lang.annotation.*;
import java.lang.reflect.*;

//Make MyAnno repeatable
@Retention(RetentionPolicy.RUNTIME)
//The value field for @Repeatable specifies the container type for the repeatable annotation.
//The container is specified as an annotation for which the value field is an array of the repeatable annotation type.
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno {
	String str() default "Testing";

	int val() default 9000;
}

//This is the container annotation.
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
	MyAnno[] value();
}

class RepeatAnno {

// Repeat MyAnno on myMeth().
	@MyAnno(str = "First annotation", val = -1)
	@MyAnno(str = "Second annotation", val = 100)
	public static void myMeth(String str, int i) {
		RepeatAnno ob = new RepeatAnno();

		try {
			Class<?> c = ob.getClass();

			// Obtain the annotations for myMeth().
			Method m = c.getMethod("myMeth", String.class, int.class);

			// Display the repeated MyAnno annotations.
			// Pass in the class of the container annotation, not the repeatable annotation,			
			Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
			System.out.println(anno);
			
			System.out.println();
			
			// Alternative method of obtaining the repeated annotation
			// Pass the repeatable annotation type
			Annotation[] annos = m.getAnnotationsByType(MyAnno.class);
			for(Annotation a : annos)
				System.out.println(a);		

 
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}

	public static void main(String args[]) {
		myMeth("test", 10);
	}
}
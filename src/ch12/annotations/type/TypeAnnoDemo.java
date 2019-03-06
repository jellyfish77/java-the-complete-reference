package ch12.annotations.type;

//Demonstrate several type annotations. 
import java.lang.annotation.*;
import java.lang.reflect.*;

//A marker annotation that can be applied to a type. 
@Target(ElementType.TYPE_USE)
@interface TypeAnno {
}

//Another marker annotation that can be applied to a type.  
@Target(ElementType.TYPE_USE)
@interface NotZeroLen {
}

//Still another marker annotation that can be applied to a type. 
@Target(ElementType.TYPE_USE)
@interface Unique {
}

//A parameterized annotation that can be applied to a type. 
@Target(ElementType.TYPE_USE)
@interface MaxLen {
	int value();
}

//An annotation that can be applied to a field declaration. 
@Target(ElementType.FIELD)
@interface EmptyOK {
}

//An annotation that can be applied to a method declaration. 
@Target(ElementType.METHOD)
@interface Recommended {
}

//An annotation that can be applied to a type parameter. 
@Target(ElementType.TYPE_PARAMETER)
@interface What {
	String description();
}

//Use an annotation on a type parameter.
//T represents a generic type - any data type can be provided
class TypeAnnoDemo<@What(description = "Generic data type") T> {

	// Use a type annotation on a constructor.
	public @Unique TypeAnnoDemo() {
	}

	// Annotate the type (in this case String), not the field.
	@TypeAnno
	String str;

	// This annotates the field test.
	@EmptyOK
	String test;

	// Use a type annotation to annotate this (the receiver).
	public int f(@TypeAnno TypeAnnoDemo<T> this, int x) {
		return 10;
	}

	// Annotate the return type.
	public @TypeAnno Integer f2(int j, int k) {
		return j + k;
	}

	// Annotate the method declaration.
	public @Recommended Integer f3(String str) {
		return str.length() / 2;
	}

	// Use a type annotation with a throws clause.
	public void f4() throws @TypeAnno NullPointerException {
		// ...
	}

	// Annotate array levels.
	String @MaxLen(10) [] @NotZeroLen [] w;

	// Annotate the array element type.
	@TypeAnno
	Integer[] vec;

	public static void myMeth(int i) {

		// Use a type annotation on a type argument.
		TypeAnnoDemo<@TypeAnno Integer> ob = new TypeAnnoDemo<@TypeAnno Integer>();

		// Use a type annotation with new.
		@Unique
		TypeAnnoDemo<Integer> ob2 = new TypeAnnoDemo<Integer>();

		// Object x = new Integer(10);
		Object x = Integer.valueOf(10);
		Integer y;

		// Use a type annotation on a cast.
		y = (@TypeAnno Integer) x;

		// Interrogate and display all annotations

		//try {
		Class<?> c = ob.getClass();
			
		//Method m = c.getMethod("myMeth", int.class);
						

			//System.out.println(anno.str() + " " + anno.val());
		/*
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
		*/
	}

	public static void main(String args[]) {
		myMeth(10);
	}

	// Use type annotation with inheritance clause.
	class SomeClass extends TypeAnnoDemo<Boolean> {
	}
}
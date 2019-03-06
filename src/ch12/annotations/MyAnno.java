package ch12.annotations;

import java.lang.annotation.*;
//import java.lang.reflect.*;

// An annotation type declaration. 
@Retention(RetentionPolicy.RUNTIME) //avail to JVM at runtime
@interface MyAnno {
	String str();

	int val();
}
package ch12.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//An annotation type declaration that includes defaults. 
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
	String str() default "Testing";

	int val() default 9000;
}
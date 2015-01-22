package br.com.cas10.domain;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, FIELD, METHOD })
@Inherited
public @interface Name {

	String key();
	
	String catalog();
	
	String value();
	
}

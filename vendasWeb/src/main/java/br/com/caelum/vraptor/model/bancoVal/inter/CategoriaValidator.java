package br.com.caelum.vraptor.model.bancoVal.inter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.caelum.vraptor.model.bancoVal.CategoriaVal;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CategoriaVal.class })
@Documented
public @interface CategoriaValidator {

	 String message() default "Categoria já cadastrada";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
}

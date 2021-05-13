/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 *
 * @author mbs-6
 * @param <T>
 */
public class Validar<T> {

	public String validar(T t) {
		StringBuilder sb = new StringBuilder();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();

		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

		if (!constraintViolations.isEmpty()) {
			constraintViolations.forEach((cv) -> {
				sb.append("<li>");
				sb.append(cv.getMessage());
				sb.append("</li>");
			});
			return sb.toString();
		}

		return "";

	}

}

package br.com.caelum.vraptor.model.bancoVal;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.vraptor.model.bancoVal.inter.CategoriaValidator;
import br.com.caelum.vraptor.model.dao.CategoriaDao;
import br.com.caelum.vraptor.model.entidade.Categoria;

public class CategoriaVal implements ConstraintValidator<CategoriaValidator, Categoria> {
	
	@Inject
	private CategoriaDao categoriaDao;

	@Override
	public void initialize(CategoriaValidator constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Categoria value, ConstraintValidatorContext context) {
		return !categoriaDao.ehCadastrado(value);
	}

}

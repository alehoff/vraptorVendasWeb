package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.bancoVal.inter.CategoriaValidator;
import br.com.caelum.vraptor.model.dao.CategoriaDao;
import br.com.caelum.vraptor.model.entidade.Categoria;
import br.com.caelum.vraptor.util.PaginacaoUtil;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class CategoriaController {

	private Result result;
	private Validator validator;
	private CategoriaDao categoriaDao;
	private PaginacaoUtil paginacaoUtil;

	@Deprecated
	public CategoriaController() {
	}

	@Inject
	public CategoriaController(PaginacaoUtil paginacaoUtil, CategoriaDao categoriaDao, Result result,
			Validator validator) {
		this.validator = validator;
		this.result = result;
		this.categoriaDao = categoriaDao;
		this.paginacaoUtil = paginacaoUtil;
	}	

	@Get
	public void totalPaginas(String filtro) {
		long paginas = paginacaoUtil.getMaxPage(categoriaDao.getTotalRegistros(filtro == null ? "" : filtro));
		result.include("paginas", paginas);
		result.redirectTo(this).lista();
	}

	@Get
	public void lista() {
	}
	
	@Get
	public void registros(Integer indice,String filtro) {
		System.out.println("inidice"+indice+" filtro"+filtro);
		result.include("categorias", categoriaDao.getAll(filtro == null ? "" : filtro,paginacaoUtil.getIndiceBancoDados(indice),paginacaoUtil.getTotalRegistrosPorPagina()));
	}

	@Get
	public void form() {
	}

	@Transactional
	@Post
	public void salvar(@Valid @CategoriaValidator @NotNull Categoria categoria) {

		validator.onErrorForwardTo(this).form();

		if (categoria.getId() == null) {
			categoriaDao.salvar(categoria);
		} else {
			categoriaDao.getById(categoria.getId(), Categoria.class).setCategoria(categoria.getCategoria());
		}

		result.redirectTo(this).lista();
	}

	@Get
	public void edita(@NotNull Long id) {

		validator.onErrorForwardTo(this).lista();

		result.include("categoria", categoriaDao.getById(id, Categoria.class));
		result.forwardTo(this).form();
	}
}

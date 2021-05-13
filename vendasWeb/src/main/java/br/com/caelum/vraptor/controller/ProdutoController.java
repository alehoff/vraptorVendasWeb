package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.dao.EstoqueDao;
import br.com.caelum.vraptor.model.dao.ProdutoDao;
import br.com.caelum.vraptor.model.entidade.Produto;
import br.com.caelum.vraptor.model.enuns.Status;
import br.com.caelum.vraptor.model.enuns.TipoCarga;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ProdutoController {

	private Result result;
	private ProdutoDao produtoDao;
	@SuppressWarnings("unused")
	private Validator validator;

	@Inject
	public ProdutoController(EstoqueDao estoqueDao, Validator validator, Result result, ProdutoDao produtoDao) {
		this.validator = validator;
		this.result = result;
		this.produtoDao = produtoDao;
	}

	@Deprecated
	public ProdutoController() {
	}

	/**
	 * Tela para listagem de produtos
	 */
	@Get
	public void lista() {

	}

	/**
	 * Tela para cadastro de produtos
	 */
	@Get
	public void cadastro() {
		result.include("status", Status.values()).include("tiposCarga", TipoCarga.values());
	}

	@Get
	public void edita(long id) {
		result.include("produto", produtoDao.getById(id, Produto.class)).forwardTo(this).cadastro();
	}

	@Get
	public void tabelaProduto() {

	}

	@Get
	public void filtroTabela(String filtro) {
		filtro = filtro == null ? "" : filtro;
		result.include("produtos", "produtos");
		result.redirectTo(this).tabelaProduto();
	}

}

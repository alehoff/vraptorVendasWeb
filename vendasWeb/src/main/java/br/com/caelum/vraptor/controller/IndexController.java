package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class IndexController {

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {

	}

	/**
	 * Tela principal do sistema
	 */
	@Get("/")
	public void index() {
	}

}
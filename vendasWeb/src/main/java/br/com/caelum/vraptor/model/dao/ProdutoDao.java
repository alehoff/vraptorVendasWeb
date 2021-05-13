package br.com.caelum.vraptor.model.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.entidade.Produto;

public class ProdutoDao extends SuperDao<Produto> {

	@Inject
	public ProdutoDao(EntityManager manager) {
		super(manager);
	}

	public boolean ehCadastrado(Produto produto) {

		sb = new StringBuilder();
		sb.append("from Produto p where lower(p.nome) = :nome");
		if (produto.getId() != null) {
			sb.append(" and p.id != ").append(produto.getId());
		}

		try {
			return manager.createQuery(sb.toString(), Produto.class)
					.setParameter("nome", produto.getNome().toLowerCase()).getSingleResult() != null;
		} catch (Exception e) {
			return false;
		}
	}

}

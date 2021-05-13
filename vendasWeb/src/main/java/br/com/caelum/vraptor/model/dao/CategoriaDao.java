package br.com.caelum.vraptor.model.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.model.entidade.Categoria;

public class CategoriaDao extends SuperDao<Categoria> {

	@Inject
	public CategoriaDao(EntityManager manager) {
		super(manager);
	}

	public List<Categoria> getAll(String filtro,Integer indice,Integer maximo) {

		sb = new StringBuilder();

		sb.append("from Categoria c");
		if(!filtro.isEmpty()) {
			sb.append(" where upper(c.categoria) like '%").append(filtro.toUpperCase()).append("%'");
		}
		sb.append(" order by c.categoria");

		try {
			return manager.createQuery(sb.toString(), Categoria.class)
					.setMaxResults(maximo)
					.setFirstResult(indice)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Long getTotalRegistros(String filtro) {
		
		sb = new StringBuilder();
		
		sb.append("select count(c) from Categoria c");
		if(!filtro.isEmpty()) {
			sb.append(" where upper(c.categoria) like '%").append(filtro.toUpperCase()).append("%'");
		}
		
		return (Long) manager.createQuery(sb.toString()).getSingleResult();
	}

	public Boolean ehCadastrado(Categoria categoria) {

		sb = new StringBuilder();

		sb.append("from Categoria c");
		sb.append(" where upper(c.categoria) = :categoria");
		if (categoria.getId() != null) {
			sb.append(" and c.id != :id");
		}

		try {
			TypedQuery<Categoria> query = manager.createQuery(sb.toString(), Categoria.class);

			query.setParameter("categoria", categoria.getCategoria().toUpperCase());

			if (categoria.getId() != null) {
				query.setParameter("id", categoria.getId());
			}

			return query.getSingleResult() != null;
		} catch (Exception e) {
			return false;
		}

	}

}

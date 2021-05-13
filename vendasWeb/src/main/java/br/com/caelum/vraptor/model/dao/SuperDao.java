package br.com.caelum.vraptor.model.dao;

import javax.persistence.EntityManager;

public abstract class SuperDao<T> {

	protected EntityManager manager;
	protected StringBuilder sb;

	public SuperDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(T t) {
		manager.persist(t);
		this.manager.flush();
	}

	public void editar(T t) {
		manager.merge(t);
		this.manager.flush();
	}

	public T getById(long id, Class<T> classe) {
		return manager.find(classe, id);
	}
}

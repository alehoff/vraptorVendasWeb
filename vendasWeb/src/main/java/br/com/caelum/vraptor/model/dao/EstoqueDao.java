/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.model.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.entidade.Estoque;

/**
 *
 * @author mbs-6
 */
public class EstoqueDao extends SuperDao<Estoque> {

	@Inject
	public EstoqueDao(EntityManager manager) {
		super(manager);
	}
	
	
	
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.model.enuns;

/**
 *
 * @author mbs-6
 */
public enum Status {
    
    ATIVO("Ativo"), INATIVO("Inativo");
    
    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    
    
}

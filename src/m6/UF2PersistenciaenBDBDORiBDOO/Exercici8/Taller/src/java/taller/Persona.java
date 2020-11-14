/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author PC-Casa
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    Long id;
    String dni;
    String nomComplet;

    public Persona() {
    }

    public Persona(Long id, String dni, String nomComplet) {
        this.id = id;
        this.dni = dni;
        this.nomComplet = nomComplet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    
    
}

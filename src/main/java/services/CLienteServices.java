/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CLienteServices {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;
    
     public List getAll() {
        return em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
    }

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }
    
     public void update(Cliente cliente) {
        em.merge(cliente);
    }

    public void create(Cliente cliente) {
        em.persist(cliente);
    }

    public void delete(Cliente cliente) {
        if (!em.contains(cliente)) {
            cliente = em.merge(cliente);
        }

        em.remove(cliente);
    }
}

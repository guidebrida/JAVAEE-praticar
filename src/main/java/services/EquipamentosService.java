/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Equipamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EquipamentosService {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Equipamento.findAll", Equipamento.class).getResultList();
    }

    public Equipamento findById(Long id) {
        return em.find(Equipamento.class, id);
    }

    public void update(Equipamento equipamento) {
        em.merge(equipamento);
    }

    public void create(Equipamento equipamento) {
        em.persist(equipamento);
    }

    public void delete(Equipamento equipamento) {
        if (!em.contains(equipamento)) {
            equipamento = em.merge(equipamento);
        }

        em.remove(equipamento);
    }

}

package services;

import domain.Cliente;
import domain.OrdemDeServico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrdemDeServicoService {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    
     public List getAll() {
        return em.createNamedQuery("OrdemDeServico.findAll", OrdemDeServico.class).getResultList();
    }

    public OrdemDeServico findById(Long id) {
        return em.find(OrdemDeServico.class, id);
    }
    
       public void update(OrdemDeServico ordemDeServico) {
        em.merge(ordemDeServico);
    }

    public void create(OrdemDeServico ordemDeServico) {
        em.persist(ordemDeServico);
    }

    public void delete(OrdemDeServico ordemDeServico) {
        if (!em.contains(ordemDeServico)) {
            ordemDeServico = em.merge(ordemDeServico);
        }

        em.remove(ordemDeServico);
    }
    
    
}

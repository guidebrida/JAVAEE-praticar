
package services;

import domain.Endereco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoService {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Endereco.findAll", Endereco.class).getResultList();
    }

    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    public void update(Endereco endereco) {
        em.merge(endereco);
    }

    public void create(Endereco endereco) {
        em.persist(endereco);
    }

    public void delete(Endereco endereco) {
        if (!em.contains(endereco)) {
            endereco = em.merge(endereco);
        }

        em.remove(endereco);
    }
}

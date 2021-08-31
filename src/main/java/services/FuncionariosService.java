package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import domain.Funcionario;

@Stateless
public class FuncionariosService {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Funcionario.findAll", Funcionario.class).getResultList();
    }

    public Funcionario findById(Long id) {
        return em.find(Funcionario.class, id);
    }

}

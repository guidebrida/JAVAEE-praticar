package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import domain.Funcionario;
import dto.FuncionarioDTO;

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

    public void create(Funcionario funcionario) {
        em.persist(funcionario);
    }

    public Funcionario fromDTO(FuncionarioDTO objDto) {
        return new Funcionario(objDto.getId(), objDto.getFuncionarios(), objDto.getUsuario());

    }

    public void delete(Funcionario funcionario) {
        if (!em.contains(funcionario)) {
            funcionario = em.merge(funcionario);
        }

        em.remove(funcionario);
    }

}

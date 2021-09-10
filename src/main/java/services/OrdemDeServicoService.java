package services;

import domain.Cliente;
import domain.Equipamento;
import domain.OrdemDeServico;
import domain.enums.Status;
import dto.OrdemDeServicoDTO;
import dto.OrdemDeServicoNewDTO;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrdemDeServicoService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    ClienteService clienteService;

    public List getAll() {
        return em.createNamedQuery("OrdemDeServico.findAll", OrdemDeServico.class).getResultList();
    }

    public OrdemDeServico findById(Integer id) {
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

//    public OrdemDeServico fromDTO(OrdemDeServicoDTO objDto) {
//        return new OrdemDeServico(objDto.getId(), null, null);
//    }
    public OrdemDeServico fromDTO(OrdemDeServicoNewDTO objDto) {
        OrdemDeServico ord = new OrdemDeServico();
        Cliente cli = clienteService.findById(objDto.getClienteId());
        Equipamento eq = new Equipamento(null, objDto.getNome(), objDto.getMarca(), objDto.getDescricao(), objDto.getDefeito());
        ord.setInstante(LocalDateTime.now());
        ord.setStatus(Status.toEnum(objDto.getStatus()));
        ord.setCliente(cli);
        ord.setImageUrl(objDto.getImageUrl());
        eq.setOrdemDeServico(ord);
        ord.setEquipamentos(eq.getOrdemDeServico().getEquipamentos());
        return ord;
    }

    private void updateData(OrdemDeServico newObj, OrdemDeServico obj) {
        newObj.setInstante(obj.getInstante());
        newObj.setCliente(obj.getCliente());
        newObj.setEquipamentos(obj.getEquipamentos());
        newObj.setImageUrl(obj.getImageUrl());
    }

//    
//      public OrdemDeServico aprovarStatus(Integer id){
//        OrdemDeServico obj = find(id);
//        obj.setStatus(Status.APROVADO);
//        return repo.save(obj);
//    }
//
//    public OrdemDeServico rejeitarStatus(Integer id){
//        OrdemDeServico obj = find(id);
//        obj.setStatus(Status.REJEITADO);
//        return repo.save(obj);
//    }
}

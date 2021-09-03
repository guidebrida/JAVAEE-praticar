/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Cliente;
import domain.Endereco;
import dto.ClienteDTO;
import dto.ClienteNewDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteService {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
    }

    public Cliente findById(Integer id) {
        return em.find(Cliente.class, id);
    }

    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    public void create(ClienteNewDTO objDto) {
        Cliente cli = new Cliente();

        cli = this.fromDTO(objDto);

        em.persist(cli);
    }

    public void delete(Cliente cliente) {
        if (!em.contains(cliente)) {
            cliente = em.merge(cliente);
        }

        em.remove(cliente);
    }

    public Cliente fromDTO(ClienteNewDTO objDto) {
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getEstado());
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfCnpj(), objDto.getTelefone(), objDto.getTipoCliente());
        em.merge(end);
        cli.setEndereco(end);
        end.setCliente(cli);
        return cli;
    }

    public void update(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = this.findById(id);
        this.updateDatabase(cliente, clienteDTO);
        em.persist(cliente);
    }

    public void updateDatabase(Cliente cliente, ClienteDTO objDto) {
        cliente.setNome(objDto.getNome());
        cliente.setTelefone(objDto.getTelefone());
        cliente.setCpfCnpj(objDto.getCpfCnpj());
        cliente.setEmail(objDto.getEmail());
        cliente.setTipo(objDto.getTipoCliente());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.Cliente;
import domain.Funcionario;
import domain.enums.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.ClienteService;

@Path("clientes")
public class ClientesResource {

    @Inject
    ClienteService clienteServices;

    @GET
    public Response getALL() {
        return Response.ok(clienteServices.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        Cliente Cliente = clienteServices.findById(id);

        return Response.ok(Cliente).build();
    }

    @POST
    public Response create(Cliente cliente) {
        clienteServices.create(cliente);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Cliente cliente) {
        Cliente clienteUpdate = clienteServices.findById(id);
        clienteUpdate.setCpfCnpj(cliente.getCpfCnpj());
        clienteUpdate.setEmail(cliente.getEmail());
        clienteUpdate.setNome(cliente.getNome());
        clienteUpdate.setTelefone(cliente.getTelefone());
        clienteServices.update(clienteUpdate);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Cliente cliente = clienteServices.findById(id);

        clienteServices.delete(cliente);

        return Response.ok().build();
    }

}

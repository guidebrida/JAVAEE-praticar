/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.Cliente;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import services.ClienteService;
import dto.ClienteNewDTO;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("clientes")
public class ClientesResource {

    @Inject
    ClienteService clienteServices;

    @GET
    public Response getALL() {
        return Response.ok(clienteServices.getAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getTodo(@PathParam("id") Integer id) {
        Cliente Cliente = clienteServices.findById(id);

        return Response.ok(Cliente).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(ClienteNewDTO clinewDTO) {
        clienteServices.create(clinewDTO);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response update(@PathParam("id") Integer id, Cliente cliente) {
        Cliente clienteUpdate = clienteServices.findById(id);
        clienteUpdate.setCpfCnpj(cliente.getCpfCnpj());
        clienteUpdate.setEmail(cliente.getEmail());
        clienteUpdate.setNome(cliente.getNome());
        clienteUpdate.setTelefone(cliente.getTelefone());
        clienteServices.update(clienteUpdate);

        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        Cliente cliente = clienteServices.findById(id);

        clienteServices.delete(cliente);

        return Response.ok().build();
    }

}

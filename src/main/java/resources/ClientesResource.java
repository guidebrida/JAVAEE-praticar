/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.Cliente;
import domain.enums.TipoCliente;
import java.util.ArrayList;
import java.util.List;
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

@Path("clientes")
public class ClientesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Cliente> listClientes() {
        Cliente c1 = new Cliente();
        c1.setId(null);
        c1.setCpfCnpj("0900909090");
        c1.setEmail("guilhermedebrida@gmail.com");
        c1.setNome("Guilherme De Brida De Bona");
        c1.setTelefone("999569064");
        c1.setTipo(0);

        Cliente c2 = new Cliente();
        c2.setId(null);
        c2.setCpfCnpj("52552522525");
        c2.setEmail("joaozinhodasilva@gmail.com");
        c2.setNome("Joazinho da silva");
        c2.setTelefone("5151554441");
        c2.setTipo(1);

        Cliente c3 = new Cliente();
        c3.setId(null);
        c3.setCpfCnpj("56816916");
        c3.setEmail("marioalaia@gmail.com");
        c3.setNome("marioalaia");
        c3.setTelefone("951051051");
        c3.setTipo(1);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        return clientes;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Cliente getCliente(@PathParam("id") Integer id) {
        Cliente c1 = new Cliente();
        c1.setId(id);
        c1.setCpfCnpj("ID DO CPF " + id);
        c1.setEmail("ID DO EMAIL: " + id);
        c1.setNome("ID DO NOME: " + id);
        c1.setTelefone("ID DO Telefone: " + id);
        c1.setTipo(id);
        return c1;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Cliente cliente) {
        System.out.println(cliente.toString());
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Cliente cliente) {
        System.out.println(cliente.toString());
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        System.out.println("Deletando ID: " + id);
        return Response.status(Response.Status.OK).build();
    }
}

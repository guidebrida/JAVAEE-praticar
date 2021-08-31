/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.Cliente;
import domain.Endereco;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import services.EnderecoService;

@Path("enderecos")
public class EnderecoResources {

    @Inject
    EnderecoService enderecoService;

    @GET
    public Response getALL() {
        return Response.ok(enderecoService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        Endereco endereco = enderecoService.findById(id);

        return Response.ok(endereco).build();
    }

    @POST
    public Response create(Endereco endereco) {
        enderecoService.create(endereco);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Endereco endereco = enderecoService.findById(id);

        enderecoService.delete(endereco);

        return Response.ok().build();
    }

}

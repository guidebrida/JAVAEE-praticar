/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.Cliente;
import domain.OrdemDeServico;
import java.time.LocalDateTime;
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
import services.OrdemDeServicoService;

@Path("ordemdeservicos")
public class OrdemDeServicoResource {

    @Inject
    OrdemDeServicoService ordemDeServicoService;

    @GET
    public Response getALL() {
        return Response.ok(ordemDeServicoService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        OrdemDeServico ordemDeServico = ordemDeServicoService.findById(id);

        return Response.ok(ordemDeServico).build();
    }

    @POST
    public Response create(OrdemDeServico ordemDeServico) {
        ordemDeServicoService.create(ordemDeServico);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Cliente cliente) {
        OrdemDeServico OrdemDeServicoUpdate = ordemDeServicoService.findById(id);
        OrdemDeServicoUpdate.setInstante(LocalDateTime.MIN);
        ordemDeServicoService.update(OrdemDeServicoUpdate);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        OrdemDeServico ordemDeServico = ordemDeServicoService.findById(id);

        ordemDeServicoService.delete(ordemDeServico);

        return Response.ok().build();
    }
    
    

}

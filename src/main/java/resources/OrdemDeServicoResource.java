/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.OrdemDeServico;
import java.time.LocalDateTime;
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

@Path("ordemdeservicos")
public class OrdemDeServicoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrdemDeServico getOrdemDeServico(@PathParam("Id") Integer id) {
        OrdemDeServico o1 = new OrdemDeServico();
        o1.setId(1);
        o1.setCliente(null);
        o1.setInstante(LocalDateTime.now());
        o1.setImageUrl("https://debrida-projeto-betha.s3.sa-east-1.amazonaws.com/odfoto.jpg");
        o1.setEquipamentos(null);
        o1.setStatus(1);
        return o1;
    }    
        @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(OrdemDeServico ordemDeServico) {
        System.out.println(ordemDeServico.toString());
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(OrdemDeServico ordemDeServico) {
        System.out.println(ordemDeServico.toString());
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        System.out.println("Deletando ID: " + id);
        return Response.status(Response.Status.OK).build();
    }
}

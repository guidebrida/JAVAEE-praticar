package resources;

import domain.Cliente;
import domain.Funcionario;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import services.FuncionariosService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("funcionarios")
public class FuncionariosResource {

    @Inject
    FuncionariosService funcionariosService;

    @GET
    public Response getALL(){
        return Response.ok(funcionariosService.getAll()).build();
    }
    
      @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        Funcionario funcionario = funcionariosService.findById(id);

        return Response.ok(funcionario).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Funcionario funcionario) {
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Funcionario funcionario) {

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        return Response.status(Response.Status.OK).build();
    }
}

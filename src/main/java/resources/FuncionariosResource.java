package resources;

import domain.Cliente;
import domain.Funcionario;
import domain.OrdemDeServico;
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
    public Response getALL() {
        return Response.ok(funcionariosService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        Funcionario funcionario = funcionariosService.findById(id);

        return Response.ok(funcionario).build();
    }

    @POST
    public Response create(Funcionario funcionario) {
        funcionariosService.create(funcionario);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Funcionario funcionario = funcionariosService.findById(id);

        funcionariosService.delete(funcionario);

        return Response.ok().build();
    }
}

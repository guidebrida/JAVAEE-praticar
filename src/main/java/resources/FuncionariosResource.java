
package resources;

import domain.Cliente;
import domain.Funcionario;
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



@Path("funcionarios")
public class FuncionariosResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario getFuncionario (@PathParam("Id") Integer id){
        Funcionario f1 = new Funcionario();
        f1.setId(1);
        f1.setUsuario("joazin");
        f1.setSenha("123");
     return f1;
    } 
    
     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Funcionario funcionario) {
        System.out.println(funcionario.toString());
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Funcionario funcionario) {
        System.out.println(funcionario.toString());
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        return Response.status(Response.Status.OK).build();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domain.Equipamento;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import services.EquipamentosService;

@Path("equipamentos")
public class EquipamentosResources {

    @Inject
    EquipamentosService equipamentosService;

    @GET
    public Response getALL() {
        return Response.ok(equipamentosService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Integer id) {
        Equipamento equipamento = equipamentosService.findById(id);

        return Response.ok(equipamento).build();
    }

    @POST
    public Response create(Equipamento equipamento) {
        equipamentosService.create(equipamento);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, Equipamento equipamento) {
        Equipamento equipamentoUpdate = equipamentosService.findById(id);
        equipamentoUpdate.setNome(equipamento.getNome());
        equipamentoUpdate.setDefeito(equipamento.getDefeito());
        equipamentoUpdate.setMarca(equipamento.getMarca());
        equipamentoUpdate.setDescricao(equipamento.getDescricao());
        equipamentosService.update(equipamentoUpdate);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        Equipamento equipamento = equipamentosService.findById(id);
        equipamentosService.delete(equipamento);
        return Response.ok().build();
    }
}

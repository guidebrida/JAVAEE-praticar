/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Cliente;
import domain.enums.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class DBservice {

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

}

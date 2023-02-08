package br.com.leoamorimrosa.cliente;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> findAll() {
        return Cliente.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@QueryParam("id") long id) {
        return Cliente.findById(id);
    }

    @DELETE
    @Path("deleteById")
    public void deleteById(long id) {
        Cliente.deleteById(id);
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newClient(Cliente cliente) {
        cliente.id = null;
        Cliente.persist(cliente);
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}

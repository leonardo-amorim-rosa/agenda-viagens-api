package br.com.leoamorimrosa.reserva;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reserva")
public class ReservaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> findAll() {
        return Reserva.listAll();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response novaReserva(Reserva reserva) {
        reserva.id = null;
        Reserva.persist(reserva);
        return Response.status(Response.Status.CREATED).entity(reserva).build();
    }
}

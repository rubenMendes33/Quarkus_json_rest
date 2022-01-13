package org.acme.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("/popcorn")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PopCornResource {
    private Set<PopCorn> popCorns = Collections.synchronizedSet(new LinkedHashSet<>());

    public PopCornResource() {
        popCorns.add(new PopCorn("PopCorn1", "One PopCorn"));
        popCorns.add(new PopCorn("PopCorn2","2 Popcorn"));

    }

    @GET
    public Response list(){
        return Response.ok(popCorns).build();
    }
    @POST
    public Set<PopCorn> add(PopCorn popCorn) {
        popCorns.add(popCorn);
        return popCorns;
    }

    @DELETE
    public Set<PopCorn> delete(PopCorn popCorn) {
        popCorns.removeIf(existingFruit -> existingFruit.name.contentEquals(popCorn.name));
        return popCorns;
    }
}
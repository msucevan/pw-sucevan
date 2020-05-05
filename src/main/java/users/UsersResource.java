/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.Collection;
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

/**
 *
 * @author spaceman33
 */
@Path("users")
public class UsersResource {

    @Inject
    UserStore store;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> all() {
        System.out.println("Funziona?");
        return store.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Long id) {
        return store.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User u) {
        User saved = store.create(u);
        return saved;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(@PathParam("id") Long id, User u) {
        if (u.getId() == null || !u.getId().equals(id)) {
            throw new IllegalArgumentException("Risorsa con id non valido!");
        }
        return store.update(u);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        store.delete(id);
    }
}

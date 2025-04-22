package fss.api;

import fss.dto.res.CustomerOrderSummaryView;
import fss.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Optional;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    @Path("{id}/orders")
    public Response getOrdersByCustomer(Integer id) {
        Optional<CustomerOrderSummaryView> customerWithOrders = customerService.findOrdersByCustomer(id);
        if (customerWithOrders.isPresent()) {
            return Response.ok(customerWithOrders.get()).build(); // Devuelve el DTO/Record
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}

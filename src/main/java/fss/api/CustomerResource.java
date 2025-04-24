package fss.api;

import fss.domain.model.Customer;
import fss.dto.res.OrdersByCustomerRes;
import fss.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    @Path("/name/{name}")
    public Optional<Customer> getByName(@PathParam("name") String name) {
        return customerService.getCustomerByName(name);
    }

    @GET
    @Path("/{id}")
    public Optional<Customer> getById(@PathParam("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @GET
    @Path("/")
    public List<Customer> allCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    @Path("/routes")
    public Response allCustomersByRoutes(Set<String> rutas) {
        List<Customer> allCustomersByRoutes = customerService.getAllCustomersByRoutes(rutas);
        
        allCustomersByRoutes.stream().forEach(customer->{
        System.out.printf("ID:%05d | Nombre:%s | Ruta:%s %n",customer.id,customer.name, customer.route);
        });
                
        
        return Response.ok().build();
    }

    @GET
    @Path("{id}/orders")
    public Response getOrdersByCustomer(Integer id) {
        Optional<OrdersByCustomerRes> findOrdersByCustomer = customerService.findOrdersByCustomer(id);
        if (findOrdersByCustomer.isPresent()) {
            return Response.ok(findOrdersByCustomer.get()).build(); // Devuelve el DTO/Record
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    //    @POST
//    @Path("/new")
//    public String create(Book book) {
//        library.add(book);
//        return "Added " + book.isbn;
//    }

}

package fss.api;

import fss.dto.res.ProductSummary;
import fss.domain.model.Product;
import fss.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    
 @Inject
 ProductService productService; 
 
//    @GET
//    @Path("/{id}")
//    public Response getProduct(@PathParam("id") Integer id) {
//        Optional<ProductSummary> productSummary = productService.getProductSummaryById(id); // Llama a la capa de servicio
//        if (productSummary.isPresent()) {
//            return Response.ok(productSummary.get()).build(); // Devuelve el DTO/Record
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }

    @GET
    public List<ProductSummary> getAllProducts() {
        return productService.getAllProductSummaries(); // Llama a la capa de servicio que devuelve lista de DTOs
    }

//    @POST
//    public Response createProduct(Product product) { // Podrías recibir un DTO de entrada aquí también
//        Product createdProduct = productService.createProduct(product);
//        // Generalmente se devuelve la ubicación del nuevo recurso o el recurso creado
//        return Response.status(Response.Status.CREATED)
//                       .entity(new ProductSummary(createdProduct.id, createdProduct.name, createdProduct.unitSale)) // Devuelve el DTO del producto creado
//                       .build();
//    }
    
}

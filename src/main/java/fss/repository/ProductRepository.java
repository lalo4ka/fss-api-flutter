package fss.repository;


import fss.domain.model.Product;
import fss.dto.res.ProductSummary;
import jakarta.data.Sort;
import jakarta.data.page.CursoredPage;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Delete;
import jakarta.data.repository.Find;
import jakarta.data.repository.Insert;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;
import jakarta.data.repository.Update;
import java.util.List;
import java.util.Optional;
import org.hibernate.query.Order;

/**
 *
 * @author ehernandez
 */

@Repository
public interface ProductRepository {
    
    @Find
    Optional<Product> findById(Integer id);
    
    @Find
    List<Product> findAllProducts();
    
    @Insert
    Product insert(Product p);
    
    @Update
    Product update(Product p);
    
    @Save
    Product upsert(Product p);
    
    @Save
    Product[] save(Product... p);
    
    @Delete
    Product delete(Product p);
    
    
    @Query("""
           select p.id, p.name, p.unitSale
           from Product p            
           """)        
    List<ProductSummary> findAllProductsSummarize(PageRequest page);
    
}

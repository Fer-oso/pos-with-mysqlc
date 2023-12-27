package interfaces.persistences.repositorys.entitys.products;

import interfaces.entitys.product.IProduct;
import interfaces.persistences.crud.CrudRepository;
import java.util.Optional;

public interface IProductRepository<T extends IProduct,ID> extends CrudRepository<T, ID>{  
    
    Optional<T> findByProductCode(String productCode);
    
}

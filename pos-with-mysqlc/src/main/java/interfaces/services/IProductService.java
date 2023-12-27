package interfaces.services;

import interfaces.entitys.product.IProduct;
import interfaces.services.crud.CrudService;

public interface IProductService<T extends IProduct, ID> extends CrudService<T, ID>{

    T findByProductCode(String productCode);
    
}

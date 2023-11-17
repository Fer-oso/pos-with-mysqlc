package interfaces.persistences.repositorys.entitys.products;

import interfaces.entitys.product.IProduct;
import interfaces.persistences.crud.CrudRepository;

public interface IProductRepository<T extends IProduct,ID> extends CrudRepository<T, ID>{  
}

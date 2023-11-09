package interfaces.services;

import interfaces.entitys.product.IProduct;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.services.crud.CrudService;

public interface IProductService<T extends IProduct, ID> extends CrudService<T, ID>, FindById<T, ID>, FindAll<T>{
    
}

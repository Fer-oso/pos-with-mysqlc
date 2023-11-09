package interfaces.services.crud;

import interfaces.persistences.crud.Crud;
import interfaces.services.Service;

public interface CrudService<T, ID> extends Crud<T, ID>, Service<T>{
    
}

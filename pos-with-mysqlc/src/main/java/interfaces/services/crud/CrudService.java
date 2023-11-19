package interfaces.services.crud;

import interfaces.services.Service;
import java.util.ArrayList;

public interface CrudService<T, ID> extends Service<T, ID> {

    public T save(T object);

    public T update(ID id, T object);

    public void delete(ID id);
    
    public ArrayList<T> findAll();
    
    public T findById(ID id);
}

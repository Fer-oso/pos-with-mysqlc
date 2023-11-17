package interfaces.services.crud;

import interfaces.services.Service;

public interface CrudService<T, ID> extends Service<T, ID> {

    @Override
    public T save(T object);

    @Override
    public T update(ID id, T object);

    @Override
    public void delete(ID id);
}

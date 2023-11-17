package interfaces.services;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Optional;
import services.exceptions.ClientServiceExceptions;

public interface Service<T, ID> extends Serializable {

    default <S extends T> S create(Class<S> normalClientType) throws Exception {

        try {

            Constructor<S> normalClientContructor = normalClientType.getDeclaredConstructor();

            S normalClientInstance = normalClientContructor.newInstance();

            return normalClientInstance;

        } catch (SecurityException | IllegalArgumentException ex) {

            throw new ClientServiceExceptions(ex.getMessage());
        }

    }

    public T save(T object);

    public T update(ID id, T object);

    public void delete(ID id);
    
    public ArrayList<T> findAll();
    
    public T findById(ID id);


}

package interfaces.persistences.crud;

import java.util.Optional;

public interface Update<T,ID> {
    
    Optional<T> update (ID id, T object);
    
}

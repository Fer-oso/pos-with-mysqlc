package interfaces.persistences.repositorys;

import java.util.Optional;

public interface FindById<T, K> {
    
    Optional<T> findById (K id);
}

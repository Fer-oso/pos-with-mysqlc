package interfaces.persistences.crud;

import java.util.Optional;

@FunctionalInterface
public interface Save<T> {
    
    Optional<T> save(T object);
}

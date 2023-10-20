package interfaces.persistences.crud;

@FunctionalInterface
public interface Save<T> {

    T save(T object) throws Exception;
}

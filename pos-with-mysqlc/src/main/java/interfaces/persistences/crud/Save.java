package interfaces.persistences.crud;

@FunctionalInterface
public interface Save<T> {

    void save(T object) throws Exception;
}

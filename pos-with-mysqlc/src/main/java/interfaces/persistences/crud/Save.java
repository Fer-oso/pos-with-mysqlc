package interfaces.persistences.crud;

public interface Save<T> {

    void save(T object) throws Exception;
}

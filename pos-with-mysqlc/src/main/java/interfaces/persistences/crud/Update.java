package interfaces.persistences.crud;

public interface Update<T,ID> {
    
    T update (ID id, T object) throws Exception;
    
}

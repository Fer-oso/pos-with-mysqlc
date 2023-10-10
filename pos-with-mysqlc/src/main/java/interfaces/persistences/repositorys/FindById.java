package interfaces.persistences.repositorys;

public interface FindById<T extends Object,K extends Object> {
    
    T findById (K id) throws Exception;
}

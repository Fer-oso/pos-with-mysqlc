package interfaces.persistences.repositorys;

import java.util.ArrayList;

public interface FindAll<T> {
    
    ArrayList<T> findAll() throws Exception;
}

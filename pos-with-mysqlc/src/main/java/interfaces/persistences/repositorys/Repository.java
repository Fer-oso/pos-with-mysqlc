package interfaces.persistences.repositorys;

import java.io.Serializable;

public interface Repository<T, ID> extends FindById<T, ID>, FindAll<T>,Serializable{
   
}

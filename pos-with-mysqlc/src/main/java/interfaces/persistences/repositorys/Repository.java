package interfaces.persistences.repositorys;

public interface Repository<T, ID> extends FindById<T, ID>, FindAll<T>{
   
}

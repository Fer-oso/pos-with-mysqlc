package interfaces.persistences.repositorys;

public interface Repository<T extends Object,ID extends Object> extends FindById<T, ID>, FindAll<T>{
   
}

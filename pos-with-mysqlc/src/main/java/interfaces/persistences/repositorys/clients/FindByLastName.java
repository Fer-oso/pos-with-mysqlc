package interfaces.persistences.repositorys.clients;

public interface FindByLastName<T extends Object> {
    
    <S extends T> S findByLastName(String lastName);
}

package interfaces.persistences.repositorys.entitys.clients;

public interface FindBySsn<T extends Object> {

    T findBySsn(Integer ssn);
}

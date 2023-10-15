package interfaces.persistences.repositorys.entitys.clients.client;

public interface FindBySsn<T extends Object> {

    T findBySsn(String ssn) throws Exception;
}

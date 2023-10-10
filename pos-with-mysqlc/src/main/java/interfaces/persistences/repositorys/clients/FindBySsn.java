package interfaces.persistences.repositorys.clients;

public interface FindBySsn<T extends Object> {

    <S extends T> S findBySsn(Integer ssn);
}

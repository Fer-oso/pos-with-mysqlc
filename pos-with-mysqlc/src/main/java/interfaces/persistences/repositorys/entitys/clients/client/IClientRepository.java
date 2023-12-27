package interfaces.persistences.repositorys.entitys.clients.client;

import entitys.models.addres.Address;
import entitys.models.phone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.persistences.crud.CrudRepository;
import java.util.ArrayList;

public interface IClientRepository<T extends IClient,ID> extends CrudRepository<T, ID> {
    
    ArrayList<T> findAllBy(Object value);
    
    void insertClientAddress(T client, Address... address) throws Exception;

    void insertClientPhone(T client, Telephone... phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;
}

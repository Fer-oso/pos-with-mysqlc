package interfaces.services.client;

import entitys.models.addres.Address;
import entitys.models.phone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.services.crud.CrudService;
import java.util.ArrayList;
import java.util.Optional;

public interface IClientService<T extends IClient, ID> extends CrudService<T, ID>{
    
    ArrayList<T> findAllBy(Object value);
    
    Optional<T> findBySsn(String ssn);
    
    void insertClientAddress(T client, Address... address) throws Exception;
    
    void insertClientPhones(T client, Telephone... telephones) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;
}

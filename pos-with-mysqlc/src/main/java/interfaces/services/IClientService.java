package interfaces.services;

import entitys.models.addres.Address;
import entitys.models.phone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.services.crud.CrudService;
import java.util.ArrayList;

public interface IClientService<T extends IClient, ID> extends CrudService<T, ID>{
    
    ArrayList<T> findAllBy(Object value);
    
    void insertClientAddress(T client, Address... address) throws Exception;
    
    void insertClientPhones(T client, Telephone... telephones) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;
}

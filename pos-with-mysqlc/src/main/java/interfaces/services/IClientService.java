package interfaces.services;

import entitiys.models.addres.Address;
import entitiys.models.phone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.services.crud.CrudService;
import java.util.ArrayList;

public interface IClientService<T extends IClient, ID> extends CrudService<T, ID>{
    
    ArrayList<T> findAllBy(String value);
    
    void insertClientAddressPhone(T client, Address address, Telephone phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;
}

package interfaces.services;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByAge;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByClasification;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByLastName;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByName;
import interfaces.persistences.repositorys.entitys.clients.client.FindBySsn;
import java.util.ArrayList;

public interface IClientService<T extends IClient, ID> extends Service<T>,Save<T>, Update<T, ID>, Delete<ID>, FindById<T, ID>, FindAll<T>, FindAllByName<T>, FindAllByLastName<T>, FindAllByAge<T>, FindBySsn<T>, FindAllByClasification<T> {
    
    void insertClientAddressPhone(T client, Address address, Telephone phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;
}

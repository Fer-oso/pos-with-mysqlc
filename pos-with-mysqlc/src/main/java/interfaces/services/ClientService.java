package interfaces.services;

import entitiys.models.addres.StandardAddress;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
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

public interface ClientService extends Service<Client>,Save<Client>, Update<Client, Integer>, Delete<Integer>, FindById<Client, Integer>, FindAll<Client>, FindAllByName<Client>, FindAllByLastName<Client>, FindAllByAge<Client>, FindBySsn<Client>, FindAllByClasification<Client> {
    
    void insertClientAddressPhone(Client client, StandardAddress address, Telephone phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(Client client) throws Exception;

    ArrayList<StandardAddress> getAddressClients(Client client) throws Exception;
}

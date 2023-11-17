package services.client;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.ClientService;
import java.util.ArrayList;
import java.util.Optional;
import lombok.SneakyThrows;
import services.exceptions.ClientServiceExceptions;

public class ClientServiceImp implements ClientService {

    private static final long serialVersionUID = 1L;

    private final ClientRepository clientRepository;

    private Client client;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @SneakyThrows
    public Client save(Client object) {

        if (!checkDuplicate(object)) {

            return clientRepository.save(object).orElseThrow();

        } else {

            throw new Exception("Cant duplicate registers, that client already registered with SSN" + client.getSsn());
        }
    }

    @Override
    @SneakyThrows
    public Client update(Integer id, Client object) {

        try {

            return clientRepository.update(id, object).orElseThrow();

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        clientRepository.delete(id);
    }

    @Override
    @SneakyThrows
    public Client findById(Integer id) {

        try {

            return clientRepository.findById(id).orElseThrow();

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public ArrayList<Client> findAll() {

        try {

            return clientRepository.findAll();

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    private boolean checkDuplicate(Client object){

        return findAll().stream().anyMatch(t -> {

            client = t;

            return (t.getName().equals(object.getName())
                    && t.getLastName().equalsIgnoreCase(object.getLastName())
                    && t.getSsn().equalsIgnoreCase(object.getSsn()));
        });
    }

    @Override
    public void insertClientAddressPhone(Client client, Address address, Telephone phone) throws Exception {

        try {

            clientRepository.insertClientAddress(client, address);

            clientRepository.insertClientPhone(client, phone);

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    public ArrayList<Telephone> getPhonesClients(Client client) throws Exception {
        try {

            return clientRepository.getPhonesClients(client);

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    public ArrayList<Address> getAddressClients(Client client) throws Exception {
        try {

            return clientRepository.getAddressClients(client);

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }
}

package services.client;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.ClientService;
import java.util.ArrayList;
import lombok.SneakyThrows;
import services.exceptions.ClientServiceException;

public class ClientServiceImp implements ClientService {

    private static final long serialVersionUID = 1L;

    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @SneakyThrows
    public Client save(Client object) {

        if (checkDuplicateRegister(object)) {

            throw new ClientServiceException("Cant duplicate registers, that client already registered with SSN " + object.getSsn());

        } else {

            return clientRepository.save(object).orElseThrow();
        }
    }

    @Override
    @SneakyThrows
    public Client findById(Integer id) {

        return clientRepository.findById(id).orElseThrow(() -> new ClientServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public Client update(Integer id, Client object) {

        return clientRepository.update(id, object).orElseThrow(() -> new ClientServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientServiceException("No value present with that id"));

        clientRepository.delete(client.getId());
    }

    @Override
    @SneakyThrows
    public ArrayList<Client> findAll() {

        return clientRepository.findAll();

    }

    @Override
    public boolean checkDuplicateRegister(Client object) {

        return findAll().stream().anyMatch(t -> {

            return t.getSsn().equalsIgnoreCase(object.getSsn());

        });
    }

    @Override
    public void insertClientAddressPhone(Client client, Address address, Telephone phone) throws Exception {

        try {

            clientRepository.insertClientAddress(client, address);

            clientRepository.insertClientPhone(client, phone);

        } catch (Exception e) {

            throw new ClientServiceException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Telephone> getPhonesClients(Client client) throws Exception {
        try {

            return clientRepository.getPhonesClients(client);

        } catch (Exception e) {

            throw new ClientServiceException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Address> getAddressClients(Client client) throws Exception {
        try {

            return clientRepository.getAddressClients(client);

        } catch (Exception e) {

            throw new ClientServiceException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Client> findAllBy(String value) {

        return clientRepository.findAllBy(value);
    }

}

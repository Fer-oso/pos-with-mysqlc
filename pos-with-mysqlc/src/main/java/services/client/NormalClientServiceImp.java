package services.client;

import services.interfaces.NormalClientService;
import interfaces.persistences.repositorys.entitys.clients.normalclient.NormalClientRepository;
import java.util.List;
import java.util.Optional;
import services.exceptions.ClientServiceExceptions;
import interfaces.entitys.clients.NormalClient;

public class NormalClientServiceImp implements NormalClientService {

    NormalClientRepository normalClientRepository;

    public NormalClientServiceImp(NormalClientRepository normalClientRepository) {

        this.normalClientRepository = normalClientRepository;
    }
    /**
     * That function is used to save one client in the DataBase.
     *
     * @param object
     * @throws services.exceptions.ClientServiceExceptions
     */
    @Override
    public void save(NormalClient object) throws Exception {

        try {
            
            normalClientRepository.save(object);

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    public NormalClient update(Integer id, NormalClient object) throws Exception {
        try {

            return normalClientRepository.update(id, object);

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {

        try {

            normalClientRepository.delete(id);

        } catch (Exception e) {

            throw new ClientServiceExceptions("ID not Found" + e.getMessage());
        }
    }

    @Override
    public NormalClient findById(Integer id) throws Exception {
        try {

            Optional<NormalClient> client = Optional.ofNullable(normalClientRepository.findById(id));

            return client.orElseThrow(() -> new ClientServiceExceptions("Value not found Maybe ID doesn´t exists"));

        } catch (Exception ex) {

            throw new ClientServiceExceptions(ex.getMessage());
        }
    }

    @Override
    public NormalClient findBySsn(String ssn) throws Exception {
        try {

            Optional<NormalClient> client = Optional.ofNullable(normalClientRepository.findBySsn(ssn));

            return client.orElseThrow(() -> new ClientServiceExceptions("Value not found Maybe ID doesn´t exists"));

        } catch (Exception ex) {

            throw new ClientServiceExceptions(ex.getMessage());
        }
    }

    @Override
    public List<NormalClient> findAll() throws Exception {

        try {

            return normalClientRepository.findAll();

        } catch (Exception e) {

            throw new ClientServiceExceptions("No clients to list");
        }
    }

    @Override
    public List<NormalClient> findAllByName(String name) throws Exception {

        try {
            return normalClientRepository.findAllByName(name);

        } catch (Exception e) {

            throw new ClientServiceExceptions("No clients to list");
        }
    }

    @Override
    public List<NormalClient> findAllByLastName(String lastName) throws Exception {
        try {
            return normalClientRepository.findAllByLastName(lastName);

        } catch (Exception e) {

            throw new ClientServiceExceptions("No clients to list");
        }
    }

    @Override
    public List<NormalClient> findAllByAge(int age) throws Exception {
        try {
            return normalClientRepository.findAllByAge(age);

        } catch (Exception e) {

            throw new ClientServiceExceptions("No clients to list");
        }
    }

    @Override
    public List<NormalClient> findAllByClasification(String clasification) throws Exception {

        try {
            return normalClientRepository.findAllByClasification(clasification);

        } catch (Exception e) {

            throw new ClientServiceExceptions("No clients to list");
        }
    }
}

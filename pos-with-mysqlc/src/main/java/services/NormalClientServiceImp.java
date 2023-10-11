package services;

import entitiys.client.NormalClient;
import interfaces.persistences.repositorys.entitys.clients.normalclient.NormalClientRepository;
import java.util.List;
import java.util.Optional;
import services.exceptions.ClientServiceExceptions;
import services.interfaces.client.NormalClientService;

public class NormalClientServiceImp implements NormalClientService<NormalClient, Integer> {

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

           return normalClientRepository.update(id,object);

        } catch (Exception e) {

            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        
        try {
            
            normalClientRepository.delete(id);
            
        } catch (Exception e) {
        
            throw new ClientServiceExceptions("ID not Found"+e.getMessage());
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
    public List<NormalClient> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NormalClient> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NormalClient> findByLastName(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NormalClient> findByAge() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NormalClient findBySsn(Integer ssn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

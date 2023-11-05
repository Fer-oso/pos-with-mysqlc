package services.client;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.ClientService;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.SQLException;
import services.exceptions.ClientServiceExceptions;

public class ClientServiceImp implements ClientService {

    private static final long serialVersionUID = 1L;
    
    private final ClientRepository clientRepository;
    
    private Client standardClient;
    
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public Client save(Client object) throws Exception {
        
        if (checkDuplicate(object)) {

            return findById(standardClient.getId()).orElseThrow(() -> new Exception("Not Found"));
        
        } else {
            
            try {
                
                return clientRepository.save(object);
                
            } catch (Exception e) {
                
                throw new ClientServiceExceptions(e.getMessage());
            }
        }
    }
    
    @Override
    public Client update(Integer id, Client object) throws Exception {
        
        try {
            
            return clientRepository.update(id, object);
             
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public void delete(Integer id) throws Exception {
        
        try {
            
            clientRepository.delete(id);
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public Optional<Client> findById(Integer id) throws Exception {
        
        try {
            
            return clientRepository.findById(id);
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public ArrayList<Client> findAll() throws Exception {
        
        try {
            
            return clientRepository.findAll();
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public ArrayList<Client> findAllByName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<Client> findAllByLastName(String lastName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<Client> findAllByAge(int age) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Client findBySsn(String ssn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<Client> findAllByClasification(String clasification) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private boolean checkDuplicate(Client object) throws Exception {
        
        try {
            
            return findAll().stream().anyMatch(t -> {
                
                standardClient = t;
                
                return (t.getName().equals(object.getName())
                        && t.getLastName().equalsIgnoreCase(object.getLastName())
                        && t.getSsn().equalsIgnoreCase(object.getSsn()));
            });
            
        } catch (SQLException e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public void insertClientAddressPhone(Client client, Address address, Telephone phone) throws Exception{
    
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
            
          return  clientRepository.getPhonesClients(client);
          
        } catch (Exception e) {
        
            throw new ClientServiceExceptions(e.getMessage());
        }
    }

    @Override
    public ArrayList<Address> getAddressClients(Client client) throws Exception {
        try {
            
          return  clientRepository.getAddressClients(client);
          
        } catch (Exception e) {
        
            throw new ClientServiceExceptions(e.getMessage());
        }
    } 
}

package services.client;

import entitiys.addres.StandardAddress;
import entitiys.client.StandardClient;
import entitiys.phone.Telephone;
import java.util.List;
import interfaces.persistences.repositorys.entitys.clients.client.StandardClientRepository;
import java.util.Optional;
import interfaces.services.StandardClientService;
import java.sql.SQLException;
import services.exceptions.ClientServiceExceptions;

public class StandarClientServiceImp implements StandardClientService {
    
    private final StandardClientRepository standarClientRepository;
    
    private StandardClient standardClient;
    
    public StandarClientServiceImp(StandardClientRepository standarClientRepository) {
        this.standarClientRepository = standarClientRepository;
    }
    
    @Override
    public StandardClient save(StandardClient object) throws Exception {
        
        if (checkDuplicate(object)) {
            System.out.println("duplicated" + object);
            
            return findById(standardClient.getId()).orElseThrow(() -> new Exception("Not Found"));
        
        } else {
            
            try {
                
                return standarClientRepository.save(object);
                
            } catch (Exception e) {
                
                throw new ClientServiceExceptions(e.getMessage());
            }
        }
    }
    
    @Override
    public StandardClient update(Integer id, StandardClient object) throws Exception {
        
        try {
            
            return standarClientRepository.update(id, object);
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public void delete(Integer id) throws Exception {
        
        try {
            
            standarClientRepository.delete(id);
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public Optional<StandardClient> findById(Integer id) throws Exception {
        
        try {
            
            return standarClientRepository.findById(id);
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public List<StandardClient> findAll() throws Exception {
        
        try {
            
            return standarClientRepository.findAll();
            
        } catch (Exception e) {
            
            throw new ClientServiceExceptions(e.getMessage());
        }
    }
    
    @Override
    public List<StandardClient> findAllByName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<StandardClient> findAllByLastName(String lastName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<StandardClient> findAllByAge(int age) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public StandardClient findBySsn(String ssn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<StandardClient> findAllByClasification(String clasification) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private boolean checkDuplicate(StandardClient object) throws Exception {
        
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
    public void insertClientAddressPhone(StandardClient client, StandardAddress address, Telephone phone) throws Exception{
    
        try {
            
            standarClientRepository.insertClientAddress(client, address);
            
            standarClientRepository.insertClientPhone(client, phone);
            
        } catch (Exception e) {
        
            throw new ClientServiceExceptions(e.getMessage());
        }
    
    }
}

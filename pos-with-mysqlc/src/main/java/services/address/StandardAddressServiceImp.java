package services.address;

import entitiys.models.addres.Address;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import services.exceptions.AddresServiceException;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.services.AddressService;

public class StandardAddressServiceImp implements AddressService {

    private static final long serialVersionUID = 1L;

    private final AddressRepository addressRepository;

    private Address standardAddress;

    public StandardAddressServiceImp(AddressRepository addressRepository) {
        
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address object) throws Exception {

        if (checkDuplicate(object)) {

            System.out.println("duplicated" + object);

            return findById(standardAddress.getId()).orElseThrow(() -> new Exception("Not found"));

        } else {

            try {

                return addressRepository.save(object);

            } catch (Exception e) {

                throw new AddresServiceException(e.getMessage());
            }
        }
    }

    @Override
    public Address update(Integer id, Address object) throws Exception {

        try {

            return addressRepository.update(id, object);

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {

        try {

            addressRepository.delete(id);
            
        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<Address> findById(Integer id) throws Exception {
        try {

            return addressRepository.findById(id);

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Address> findAll() throws Exception {
        
        try {
            
            return addressRepository.findAll();
            
        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    private boolean checkDuplicate(Address address) throws Exception {

        try {

            return findAll().stream().anyMatch(t -> {

                standardAddress = t;

                return (t.getStreetNumber().equals(address.getStreetNumber())
                        && t.getStreetDirection().equalsIgnoreCase(address.getStreetDirection())
                        && t.getCity().equalsIgnoreCase(address.getCity())
                        && t.getState().equalsIgnoreCase(address.getState()));
            });

        } catch (SQLException e) {

            throw new AddresServiceException(e.getMessage());
        }
    }
}

package services.address;

import entitys.models.addres.Address;
import java.util.ArrayList;
import services.exceptions.AddresServiceException;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.services.AddressService;
import lombok.SneakyThrows;

public class AddressServiceImp implements AddressService {

    private static final long serialVersionUID = 1L;

    private final AddressRepository addressRepository;
    
     Address address;

    public AddressServiceImp(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }

    @Override
    @SneakyThrows()
    public Address save(Address object) {

        if (checkDuplicateRegister(object)) {

           return findById(address.getId());

        } else {

            return addressRepository.save(object).orElseThrow(()->new AddresServiceException("Cant duplicate address"));
        }
    }

    @Override
    @SneakyThrows
    public Address findById(Integer id) {

        return addressRepository.findById(id).orElseThrow(() -> new AddresServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public Address update(Integer id, Address object) {

        return addressRepository.update(id, object).orElseThrow(() -> new AddresServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        Address address = addressRepository.findById(id).orElseThrow(() -> new AddresServiceException("No value present with that id"));

        addressRepository.delete(address.getId());
    }

    @Override
    @SneakyThrows
    public ArrayList<Address> findAll() {

        return addressRepository.findAll();
    }

    @Override
    public boolean checkDuplicateRegister(Address address) {

        return findAll().stream().anyMatch(t -> {
            
            this.address = t;
            
            return (t.getStreetNumber().equals(address.getStreetNumber())
                    && t.getStreetDirection().equalsIgnoreCase(address.getStreetDirection())
                    && t.getCity().equalsIgnoreCase(address.getCity())
                    && t.getState().equalsIgnoreCase(address.getState()));
        });
    }
}

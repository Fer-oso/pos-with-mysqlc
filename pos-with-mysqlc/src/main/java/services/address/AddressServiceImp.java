package services.address;

import services.interfaces.AddressService;
import interfaces.entitys.addres.Address;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import java.util.List;
import services.exceptions.AddresServiceException;

public class AddressServiceImp implements AddressService {

    AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(Address object) throws Exception {
        try {

            addressRepository.save(object);

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
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
    public Address findById(Integer id) throws Exception {
        try {

            return addressRepository.findById(id);

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    public List<Address> findAll() throws Exception {
           try {

           return addressRepository.findAll();

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }
}

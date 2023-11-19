package services.address;

import entitiys.models.addres.Address;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import services.exceptions.AddresServiceException;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.services.AddressService;
import lombok.SneakyThrows;

public class AddressServiceImp implements AddressService {

    private static final long serialVersionUID = 1L;

    private final AddressRepository addressRepository;

    private Address standardAddress;

    public AddressServiceImp(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }

    @Override
    @SneakyThrows({AddresServiceException.class, Exception.class})
    public Address save(Address object) {

        if (checkDuplicateRegister(object)) {

            System.out.println("duplicated" + object);

            return findById(standardAddress.getId());

        } else {

            try {

                return addressRepository.save(object).orElseThrow();

            } catch (Exception e) {

                throw new AddresServiceException(e.getMessage());
            }
        }
    }

    @Override
    @SneakyThrows
    public Address update(Integer id, Address object) {

        try {

            return addressRepository.update(id, object).orElseThrow();

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        try {

            addressRepository.delete(id);

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public Address findById(Integer id) {
        try {

            return addressRepository.findById(id).orElseThrow();

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public ArrayList<Address> findAll() {

        try {

            return addressRepository.findAll();

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    public boolean checkDuplicateRegister(Address address) {

        return findAll().stream().anyMatch(t -> {

            standardAddress = t;

            return (t.getStreetNumber().equals(address.getStreetNumber())
                    && t.getStreetDirection().equalsIgnoreCase(address.getStreetDirection())
                    && t.getCity().equalsIgnoreCase(address.getCity())
                    && t.getState().equalsIgnoreCase(address.getState()));
        });
    }
}

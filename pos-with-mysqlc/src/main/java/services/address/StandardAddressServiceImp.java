package services.address;

import entitiys.addres.StandardAddress;
import interfaces.persistences.repositorys.entitys.address.StandardAddressRepository;
import interfaces.services.StandardAddressService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import services.exceptions.AddresServiceException;

public class StandardAddressServiceImp implements StandardAddressService {

    private final StandardAddressRepository addressRepository;

    private StandardAddress standardAddress;

    public StandardAddressServiceImp(StandardAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public StandardAddress save(StandardAddress object) throws Exception {

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
    public StandardAddress update(Integer id, StandardAddress object) throws Exception {

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
    public Optional<StandardAddress> findById(Integer id) throws Exception {
        try {

            return addressRepository.findById(id);

        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    @Override
    public List<StandardAddress> findAll() throws Exception {
        try {
            return addressRepository.findAll();
        } catch (Exception e) {

            throw new AddresServiceException(e.getMessage());
        }
    }

    private boolean checkDuplicate(StandardAddress address) throws Exception {

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

package services.phone;

import interfaces.entitys.phone.Phone;
import interfaces.persistences.repositorys.entitys.phones.PhoneRepository;
import java.util.List;
import interfaces.services.services.interfaces.PhoneService;
import java.util.Optional;
import services.exceptions.PhoneServiceException;

public class PhoneServiceImp implements PhoneService {

    PhoneRepository phoneRepository;

    public PhoneServiceImp(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Phone save(Phone object) throws Exception {
        try {

            return phoneRepository.save(object);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }

    }

    @Override
    public Phone update(Integer id, Phone object) throws Exception {
        try {

            return phoneRepository.update(id, object);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {

            phoneRepository.delete(id);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<Phone> findById(Integer id) throws Exception {
        try {

            return phoneRepository.findById(id);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    public List<Phone> findAll() throws Exception {
        try {

            return phoneRepository.findAll();

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

}

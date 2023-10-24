package services.phone;

import entitiys.phone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.services.TelephoneService;
import java.util.List;
import java.util.Optional;
import services.exceptions.PhoneServiceException;

public class TelephoneServiceImp implements TelephoneService {

   private final TelephoneRepository phoneRepository;

    public TelephoneServiceImp(TelephoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Telephone save(Telephone object) throws Exception {
        try {

            return phoneRepository.save(object);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }

    }

    @Override
    public Telephone update(Integer id, Telephone object) throws Exception {
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
    public Optional<Telephone> findById(Integer id) throws Exception {
        try {

            return phoneRepository.findById(id);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    public List<Telephone> findAll() throws Exception {
        try {

            return phoneRepository.findAll();

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

}

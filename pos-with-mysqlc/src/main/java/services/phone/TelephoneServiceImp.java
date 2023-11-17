package services.phone;

import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import java.util.ArrayList;
import services.exceptions.AddresServiceException;
import services.exceptions.PhoneServiceException;
import interfaces.entitys.phone.IPhone;
import lombok.SneakyThrows;

public class TelephoneServiceImp implements TelephoneService {

    private static final long serialVersionUID = 1L;

    private final TelephoneRepository phoneRepository;

    private Telephone telephone;

    public TelephoneServiceImp(TelephoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    @SneakyThrows
    public Telephone save(Telephone object) {

        if (checkDuplicate(object)) {

            return findById(telephone.getId());

        } else {

            try {

                return phoneRepository.save(object).orElseThrow();

            } catch (Exception e) {

                throw new AddresServiceException(e.getMessage());
            }
        }
    }

    @Override
    @SneakyThrows
    public Telephone update(Integer id, Telephone object) {
        try {

            return phoneRepository.update(id, object).orElseThrow();

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {
        try {

            phoneRepository.delete(id);

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public Telephone findById(Integer id) {
        try {

            return phoneRepository.findById(id).orElseThrow(() -> new PhoneServiceException("Value not present. Cant find by that id"));

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public ArrayList<Telephone> findAll() {
        try {

            return phoneRepository.findAll();

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    private boolean checkDuplicate(IPhone phone) {

        return findAll().stream().anyMatch(t -> {

            telephone = t;

            return (t.getNumberPhone().equals(phone.getNumberPhone())
                    && t.getTypePhone().equalsIgnoreCase(phone.getTypePhone()));
        });
    }
}

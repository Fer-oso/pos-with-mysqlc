package services.phone;

import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import java.util.ArrayList;
import services.exceptions.AddresServiceException;
import services.exceptions.PhoneServiceException;
import lombok.SneakyThrows;

public class TelephoneServiceImp implements TelephoneService {

    private static final long serialVersionUID = 1L;

    private final TelephoneRepository telephoneRepository;
    
    Telephone telephone;

    public TelephoneServiceImp(TelephoneRepository phoneRepository) {
        this.telephoneRepository = phoneRepository;
    }

    @Override
    @SneakyThrows
    public Telephone save(Telephone object) {

        if (checkDuplicateRegister(object)) {

           return findById(telephone.getId());

        } else {

            return telephoneRepository.save(object).orElseThrow(()->new AddresServiceException("Cant duplicate telephone"));
        }
    }

    @Override
    @SneakyThrows
    public Telephone findById(Integer id) {

        return telephoneRepository.findById(id).orElseThrow(() -> new PhoneServiceException("Value not present. Cant find by that id"));
    }

    @Override
    @SneakyThrows
    public Telephone update(Integer id, Telephone object) {

        return telephoneRepository.update(id, object).orElseThrow(() -> new PhoneServiceException("Value not present. Cant find by that id"));
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        Telephone telephone = telephoneRepository.findById(id).orElseThrow(() -> new PhoneServiceException("Value not present. Cant find by that id"));

        telephoneRepository.delete(telephone.getId());
    }

    @Override
    @SneakyThrows
    public ArrayList<Telephone> findAll() {

        return telephoneRepository.findAll();
    }

    @Override
    public boolean checkDuplicateRegister(Telephone object) {

        return findAll().stream().anyMatch(t -> {
            
            this.telephone = t;
            
            return (t.getNumberPhone().equals(object.getNumberPhone()));
        });
    }
}

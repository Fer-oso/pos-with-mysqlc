package services.phone;

import entitiys.models.phone.Telephone;
import interfaces.entitys.phone.Phone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.swing.JOptionPane;
import services.exceptions.AddresServiceException;
import services.exceptions.PhoneServiceException;

public class TelephoneServiceImp implements TelephoneService {

    private static final long serialVersionUID = 1L;

    private final TelephoneRepository phoneRepository;

    private Telephone telephone;

    public TelephoneServiceImp(TelephoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Telephone save(Telephone object) throws Exception {

        if (checkDuplicate(object)) {

            JOptionPane.showConfirmDialog(null, "Telephone duplicated, Ask client if the number is the correct");

            return findById(telephone.getId()).orElseThrow(() -> new Exception("Not found"));

        } else {

            try {

                return phoneRepository.save(object);

            } catch (Exception e) {

                throw new AddresServiceException(e.getMessage());
            }
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
    public ArrayList<Telephone> findAll() throws Exception {
        try {

            return phoneRepository.findAll();

        } catch (Exception e) {

            throw new PhoneServiceException(e.getMessage());
        }
    }

    private boolean checkDuplicate(Phone phone) throws Exception {

        try {

            return findAll().stream().anyMatch(t -> {

                telephone = t;

                return (t.getNumberPhone().equals(phone.getNumberPhone())
                        && t.getTypePhone().equalsIgnoreCase(phone.getTypePhone()));
            });

        } catch (SQLException e) {

            throw new AddresServiceException(e.getMessage());
        }
    }
}

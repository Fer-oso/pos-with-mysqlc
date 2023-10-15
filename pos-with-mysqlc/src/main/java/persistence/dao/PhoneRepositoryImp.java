package persistence.dao;

import entitiys.addres.RegularAddress;
import entitiys.phone.Telephone;
import interfaces.entitys.addres.Address;
import interfaces.entitys.phone.Phone;
import interfaces.persistences.repositorys.entitys.phones.PhoneRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.dao.exceptios.DaoExceptions;

public class PhoneRepositoryImp extends DaoRepository implements PhoneRepository {

    @Override
    public void save(Phone object) throws Exception {
        try {

            String sql = "INSERT INTO phone (number_phone, type_phone) VALUES (?, ?)";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, object.getNumberPhone());

            preparedStatement.setString(2, object.getTypePhone());

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error en mySQL " + e.toString());

        } finally {

            closeConnection();
        }
    }

    @Override
    public Phone update(Integer id, Phone object) throws Exception {
        try {

            String sql = "UPDATE phone SET number_phone = ?, type_phone = ? WHERE id = ?)";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, object.getNumberPhone());

            preparedStatement.setString(2, object.getTypePhone());

            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            connection.commit();

            return findById(id);

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error en mySQL " + e.toString());

        } finally {

            closeConnection();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {

            String sql = "DELETE FROM phone WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("MYSQL Error" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public Phone findById(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM phone WHERE id = ?";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Telephone(resultSet.getInt("id"),
                        resultSet.getInt("number_phone"),
                        resultSet.getString("type_phone"));
            } else {

                throw new DaoExceptions("Not Found By ID Maybe Doesn't exists");
            }
        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<Phone> findAll() throws Exception {
        try {
            String sql = "SELECT * FROM phone";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<Phone> phones = new ArrayList<>();

            while (resultSet.next()) {

                Phone phone = new Telephone(
                        resultSet.getInt("id"),
                        resultSet.getInt("number_phone"),
                        resultSet.getString("type_phone"));

                phones.add(phone);
            }

            return phones;

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }
}

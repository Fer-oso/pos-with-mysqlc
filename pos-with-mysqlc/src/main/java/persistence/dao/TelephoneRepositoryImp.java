package persistence.dao;

import entitiys.phone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import persistence.dao.exceptios.DaoExceptions;

public class TelephoneRepositoryImp extends DaoRepository implements TelephoneRepository {

    private Integer idGeneratedKey;

    @Override
    public Telephone save(Telephone object) throws Exception {
        try {

            String sql = "INSERT INTO phone (number_phone, type_phone) VALUES (?, ?)";

            preparedStatement = startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, object.getNumberPhone());

            preparedStatement.setString(2, object.getTypePhone());

            preparedStatement.executeUpdate();

            connection.commit();
            
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {

                idGeneratedKey = resultSet.getInt(1);
            }

            return findById(idGeneratedKey).get();

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error en mySQL " + e.toString());

        } finally {

            closeConnection();
        }
    }

    @Override
    public Telephone update(Integer id, Telephone object) throws Exception {
        try {

            String sql = "UPDATE phone SET number_phone = ?, type_phone = ? WHERE id = ?)";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, object.getNumberPhone());

            preparedStatement.setString(2, object.getTypePhone());

            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            connection.commit();

            return findById(id).get();

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
    public Optional<Telephone> findById(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM phone WHERE id = ?";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Telephone phone = new Telephone(resultSet.getInt("id"),
                        resultSet.getInt("number_phone"),
                        resultSet.getString("type_phone"));

                Optional<Telephone> optionalPhone = Optional.ofNullable(phone);

                return optionalPhone;

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
    public List<Telephone> findAll() throws Exception {
        try {
            String sql = "SELECT * FROM phone";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<Telephone> phones = new ArrayList<>();

            while (resultSet.next()) {

                Telephone phone = new Telephone(
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

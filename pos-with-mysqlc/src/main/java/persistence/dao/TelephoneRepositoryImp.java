package persistence.dao;

import persistence.config.DbConnector;
import entitys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import lombok.SneakyThrows;
import persistence.dao.exceptios.DaoExceptions;

public class TelephoneRepositoryImp implements TelephoneRepository {

    DbConnector dbConnector;

    public TelephoneRepositoryImp(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    private static final long serialVersionUID = 1L;

    private static Integer idGeneratedKey;

    @Override
    @SneakyThrows
    public Optional<Telephone> save(Telephone object) {
        try {

            String sql = "INSERT INTO phone (number_phone, type_phone) VALUES (?, ?)";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, object.getNumberPhone());

            preparedStatement.setString(2, object.getTypePhone());

            preparedStatement.executeUpdate();

            dbConnector.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {

                idGeneratedKey = resultSet.getInt(1);
            }

            return findById(idGeneratedKey);

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error en mySQL " + e.toString());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public Optional<Telephone> update(Integer id, Telephone object) {
        try {

            String sql = "UPDATE phone SET number_phone = ?, type_phone = ? WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, object.getNumberPhone());

            preparedStatement.setString(2, object.getTypePhone());

            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

            return findById(id);

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error en mySQL " + e.toString());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {
        try {

            String sql = "DELETE FROM phone WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("MYSQL Error" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public Optional<Telephone> findById(Integer id) {
        try {
            String sql = "SELECT * FROM phone WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

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

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public ArrayList<Telephone> findAll() {
        try {
            String sql = "SELECT * FROM phone";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Telephone> phones = new ArrayList<>();

            while (resultSet.next()) {

                Telephone phone = new Telephone(
                        resultSet.getInt("id"),
                        resultSet.getInt("number_phone"),
                        resultSet.getString("type_phone"));

                phones.add(phone);
            }

            return phones;

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }
}

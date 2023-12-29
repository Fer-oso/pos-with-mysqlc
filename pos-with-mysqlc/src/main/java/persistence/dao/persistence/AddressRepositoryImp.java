package persistence.dao.persistence;

import entitys.models.addres.Address;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import persistence.dao.exceptios.DaoExceptions;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.SneakyThrows;
import persistence.config.DbConnector;

public class AddressRepositoryImp implements AddressRepository {

    private static final long serialVersionUID = 1L;
    
    DbConnector dbConnector;

    public AddressRepositoryImp(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    private Integer idGeneratedKey;

    @Override
    @SneakyThrows
    public Optional<Address> save(Address object) {

        try {

            String sql = "INSERT INTO address (street_direction, street_number, city, state, postal_code ) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getStreetDirection());

            preparedStatement.setInt(2, object.getStreetNumber());

            preparedStatement.setString(3, object.getCity());

            preparedStatement.setString(4, object.getState());

            preparedStatement.setInt(5, object.getPostalCode());

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
    public Optional<Address> update(Integer id, Address object) {

        try {

            String sql = "UPDATE address SET  street_direction = ?, street_number = ?, city = ?, state = ?, postal_code = ? WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getStreetDirection());

            preparedStatement.setInt(2, object.getStreetNumber());

            preparedStatement.setString(3, object.getCity());

            preparedStatement.setString(4, object.getState());

            preparedStatement.setInt(5, object.getPostalCode());

            preparedStatement.setInt(6, id);

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
    public void delete(Integer id){

        try {

            String sql = "DELETE FROM address WHERE id = ?";

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
    public Optional<Address> findById(Integer id) {

        try {

            String sql = "SELECT * FROM address WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Address address = new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("street_direction"),
                        resultSet.getInt("street_number"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("postal_code"));
                Optional<Address> optionalStandardAddress = Optional.ofNullable(address);

                return optionalStandardAddress;

            } else {

                throw new DaoExceptions("Not Found by ID, maybe doesn't exists");
            }

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public ArrayList<Address> findAll() {

        try {
            String sql = "SELECT * FROM address";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Address> addresses = new ArrayList<>();

            while (resultSet.next()) {

                addresses.add(new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("street_direction"),
                        resultSet.getInt("street_number"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("postal_code")));
            }

            return addresses;

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }
}

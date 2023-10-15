package persistence.dao;

import entitiys.addres.RegularAddress;
import interfaces.entitys.addres.Address;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.dao.exceptios.DaoExceptions;

public class AddressRepositoryImp extends DaoRepository implements AddressRepository {

    @Override
    public void save(Address object) throws Exception {
        try {

            String sql = "INSERT INTO address (street_direction, street_number, city, state, postal_code ) VALUES (?, ?, ?, ?, ?)";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getStreetDirection());

            preparedStatement.setInt(2, object.getStreetNumber());

            preparedStatement.setString(3, object.getCity());

            preparedStatement.setString(4, object.getState());

            preparedStatement.setInt(5, object.getPostalCode());

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
    public Address update(Integer id, Address object) throws Exception {
        try {

            String sql = "UPDATE address SET  street_direction = ?, street_number = ?, city = ?, state = ?, postal_code = ? WHERE id = ?";

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getStreetDirection());

            preparedStatement.setInt(2, object.getStreetNumber());

            preparedStatement.setString(3, object.getCity());

            preparedStatement.setString(4, object.getState());

            preparedStatement.setInt(5, object.getPostalCode());

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

            String sql = "DELETE FROM address WHERE id = ?";

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
    public Address findById(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM address WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new RegularAddress(
                        resultSet.getInt("id"),
                        resultSet.getString("street_direction"),
                        resultSet.getInt("street_number"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("postal_code"));
            } else {
               
               throw new DaoExceptions("Not Found by ID, maybe doesn't exists");
            }

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<Address> findAll() throws Exception {
        try {
            String sql = "SELECT * FROM address";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<Address> addresses = new ArrayList<>();

            while (resultSet.next()) {

                Address address = new RegularAddress(
                        resultSet.getInt("id"),
                        resultSet.getString("street_direction"),
                        resultSet.getInt("street_number"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("postal_code"));

                addresses.add(address);
            }

            return addresses;

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

}

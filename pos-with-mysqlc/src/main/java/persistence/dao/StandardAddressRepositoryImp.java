package persistence.dao;

import entitiys.addres.StandardAddress;
import interfaces.persistences.repositorys.entitys.address.StandardAddressRepository;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import persistence.dao.exceptios.DaoExceptions;

public class StandardAddressRepositoryImp extends DaoRepository implements StandardAddressRepository {

    private Integer idGeneratedKey;

    @Override
    public StandardAddress save(StandardAddress object) throws Exception {

        try {

            

                String sql = "INSERT INTO address (street_direction, street_number, city, state, postal_code ) VALUES (?, ?, ?, ?, ?)";

                preparedStatement = startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, object.getStreetDirection());

                preparedStatement.setInt(2, object.getStreetNumber());

                preparedStatement.setString(3, object.getCity());

                preparedStatement.setString(4, object.getState());

                preparedStatement.setInt(5, object.getPostalCode());

                preparedStatement.executeUpdate();

                resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {

                    idGeneratedKey = resultSet.getInt(1);
                }

                connection.commit();

                return findById(idGeneratedKey).get();

            

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error en mySQL " + e.toString());

        } finally {

            closeConnection();
        }
    }

    @Override
    public StandardAddress update(Integer id, StandardAddress object) throws Exception {

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
    public Optional<StandardAddress> findById(Integer id) throws Exception {

        try {

            String sql = "SELECT * FROM address WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                StandardAddress standardAddress = new StandardAddress(
                        resultSet.getInt("id"),
                        resultSet.getString("street_direction"),
                        resultSet.getInt("street_number"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("postal_code"));
                Optional<StandardAddress> optionalStandardAddress = Optional.ofNullable(standardAddress);

                return optionalStandardAddress;

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
    public List<StandardAddress> findAll() throws Exception {

        try {
            String sql = "SELECT * FROM address";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<StandardAddress> addresses = new ArrayList<>();

            while (resultSet.next()) {

                addresses.add(new StandardAddress(
                        resultSet.getInt("id"),
                        resultSet.getString("street_direction"),
                        resultSet.getInt("street_number"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getInt("postal_code")));
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

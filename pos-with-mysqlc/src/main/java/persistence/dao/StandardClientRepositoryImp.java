package persistence.dao;

import entitiys.addres.StandardAddress;
import entitiys.client.StandardClient;
import entitiys.phone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.StandardClientRepository;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import persistence.dao.exceptios.DaoExceptions;

public class StandardClientRepositoryImp extends DaoRepository implements StandardClientRepository {

    private Integer idGeneratedKey;

    private StandardClient standardClient;

    @Override
    public StandardClient save(StandardClient object) throws Exception {

        try {

            String sql = "INSERT INTO clients (name, lastname, age, ssn, clasification ) VALUES (?, ?, ?, ?, ?)";

            preparedStatement = startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());

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
    public StandardClient update(Integer id, StandardClient object) throws Exception {

        String sql = "UPDATE clients SET name = ?, lastname = ?, age = ?, ssn = ?, clasification = ? WHERE id = ?";

        try {
            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());

            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

            connection.commit();

            return findById(id).get();

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {

        String sql = "DELETE FROM clients WHERE id = ?";

        try {
            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public Optional<StandardClient> findById(Integer id) throws Exception {

        try {

            String sql = "SELECT * FROM clients WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                standardClient = new StandardClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));
            }

            return Optional.ofNullable(standardClient);

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<StandardClient> findAll() throws Exception {

        try {
            String sql = "SELECT * FROM  clients";

            preparedStatement = startConnection().prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<StandardClient> normalClients = new ArrayList<>();

            while (resultSet.next()) {

                normalClients.add(new StandardClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification")));
            }

            return normalClients;

        } catch (DaoExceptions e) {

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public void insertClientAddress(StandardClient client, StandardAddress address) throws Exception {

        String sql = "INSERT INTO client_address ( id_client, id_address ) VALUES (?, ?)";

        try {

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            preparedStatement.setInt(2, address.getId());

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public void insertClientPhone(StandardClient client, Telephone phone) throws Exception {
        String sql = "INSERT INTO client_phone (id_client, id_phone) VALUES (?, ?)";

        try {
            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            preparedStatement.setInt(2, phone.getId());

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<StandardClient> findAllByName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StandardClient> findAllByLastName(String lastName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StandardClient> findAllByAge(int age) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StandardClient findBySsn(String ssn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StandardClient> findAllByClasification(String clasification) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

package persistence;

import entitiys.dto.clientdto.StandardClient;
import entitiys.models.client.Client;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import persistence.dao.DaoRepository;
import persistence.dao.exceptios.DaoExceptions;

public class ClientRepositoryImp extends DaoRepository implements ClientRepository<Client, Integer> {

    private Integer idGeneratedKey;

    private Client client;

    @Override
    public Client save(Client object) throws Exception {

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
    public Client update(Integer id, Client object) throws Exception {

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
    public Optional<Client> findById(Integer id) throws Exception {

        try {

            String sql = "SELECT * FROM clients WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"),
                        resultSet.getBoolean("available"));

            }

            return Optional.ofNullable(client);

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<Client> findAll() throws Exception {
        try {
            String sql = "SELECT * FROM  clients";

            preparedStatement = startConnection().prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<Client> clientsList = new ArrayList<>();

            while (resultSet.next()) {

                clientsList.add(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"),
                        resultSet.getBoolean("available")));
            }

            return clientsList;

        } catch (DaoExceptions e) {

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<Client> findAllByName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Client> findAllByLastName(String lastName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Client> findAllByAge(int age) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Client findBySsn(String ssn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Client> findAllByClasification(String clasification) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

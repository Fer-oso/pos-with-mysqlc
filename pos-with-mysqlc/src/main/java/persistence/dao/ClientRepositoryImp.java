package persistence.dao;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import lombok.SneakyThrows;
import persistence.config.DbConnector;
import persistence.dao.exceptios.DaoExceptions;

public class ClientRepositoryImp implements ClientRepository {

    private static final long serialVersionUID = 1L;

    DbConnector dbConnector;

    public ClientRepositoryImp(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    private Integer idGeneratedKey;

    private Client client;

    @Override
    @SneakyThrows
    public Optional<Client> save(Client object) {

        try {

            String sql = "INSERT INTO clients (name, lastname, age, ssn, clasification, available ) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());

            preparedStatement.setBoolean(6, object.isAvailability());

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
    public Optional<Client> update(Integer id, Client object) {

        String sql = "UPDATE clients SET name = ?, lastname = ?, age = ?, ssn = ?, clasification = ?, available = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());

            preparedStatement.setBoolean(6, object.isAvailability());

            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

            return findById(id);

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        String sql = "DELETE FROM clients WHERE id = ?";

        try {
            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public Optional<Client> findById(Integer id){

        try {

            String sql = "SELECT * FROM clients WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        resultSet.getString("clasification"),
                        resultSet.getBoolean("available"),
                        new ArrayList<>(),
                        new ArrayList<>());

            }

            return Optional.ofNullable(client);

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public ArrayList<Client> findAll() {
        try {
            String sql = "SELECT * FROM  clients";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Client> clientsList = new ArrayList<>();

            while (resultSet.next()) {

                clientsList.add(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        resultSet.getString("clasification"),
                        resultSet.getBoolean("available"),
                        new ArrayList<>(),
                        new ArrayList<>()));
            }

            return clientsList;

        } catch (DaoExceptions e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    public void insertClientAddress(Client client, Address address) throws Exception {

        String sql = "INSERT INTO client_address ( id_client, id_address ) VALUES (?, ?)";

        try {

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            preparedStatement.setInt(2, address.getId());

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    public void insertClientPhone(Client client, Telephone phone) throws Exception {

        String sql = "INSERT INTO client_phone (id_client, id_phone) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            preparedStatement.setInt(2, phone.getId());

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    public ArrayList<Telephone> getPhonesClients(Client client) throws Exception {

        String sql = "SELECT phone.* FROM client_phone JOIN phone ON client_phone.id_phone = phone.id WHERE client_phone.id_client = ?";

        try {

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Telephone> phonesClient = new ArrayList<>();

            while (resultSet.next()) {

                phonesClient.add(new Telephone(resultSet.getInt("id"), resultSet.getInt("number_phone"), resultSet.getString("type_phone")
                ));
            }

            return phonesClient;

        } catch (DaoExceptions e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }

    }

    @Override
    public ArrayList<Address> getAddressClients(Client client) throws Exception {

        String sql = "SELECT address.* FROM client_address JOIN address ON client_address.id_address = address.id WHERE client_address.id_client = ?";

        try {

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Address> adressClient = new ArrayList<>();

            while (resultSet.next()) {

                adressClient.add(new Address(resultSet.getInt("id"), resultSet.getString("street_direction"), resultSet.getInt("street_number"),
                        resultSet.getString("city"), resultSet.getString("state"), resultSet.getInt("postal_code")));
            }

            return adressClient;

        } catch (DaoExceptions e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    public ArrayList<Client> findAllByName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Client> findAllByLastName(String lastName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Client> findAllByAge(int age) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Client findBySsn(String ssn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Client> findAllByClasification(String clasification) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

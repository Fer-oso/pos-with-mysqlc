package persistence.dao;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import persistence.dao.exceptios.DaoExceptions;

public class ClientRepositoryImp extends DaoRepository implements ClientRepository{

    private static final long serialVersionUID = 1L;

    private Integer idGeneratedKey;

    private Client client;

    @Override
    public Client save(Client object) throws Exception {

        try {

            String sql = "INSERT INTO clients (name, lastname, age, ssn, clasification, available ) VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());
            
            preparedStatement.setBoolean(6, object.isAvailability());

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

        String sql = "UPDATE clients SET name = ?, lastname = ?, age = ?, ssn = ?, clasification = ?, available = ? WHERE id = ?";

        try {
            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());
            
            preparedStatement.setBoolean(6, object.isAvailability());

            preparedStatement.setInt(7, id);

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
                        resultSet.getString("clasification"),
                        resultSet.getBoolean("available"),
                        new ArrayList<>(),
                        new ArrayList<>());

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
    public ArrayList<Client> findAll() throws Exception {
        try {
            String sql = "SELECT * FROM  clients";

            preparedStatement = startConnection().prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

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

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
        }
    }
    
    @Override
    public void insertClientAddress(Client client, Address address) throws Exception {
        
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
    public void insertClientPhone(Client client, Telephone phone) throws Exception {

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
    public ArrayList<Telephone> getPhonesClients(Client client) throws Exception {

        String sql = "SELECT phone.* FROM client_phone JOIN phone ON client_phone.id_phone = phone.id WHERE client_phone.id_client = ?";

        try {

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            resultSet = preparedStatement.executeQuery();

            ArrayList<Telephone> phonesClient = new ArrayList<>();

            while (resultSet.next()) {

                phonesClient.add(new Telephone(resultSet.getInt("id"), resultSet.getInt("number_phone"), resultSet.getString("type_phone")
                ));
            }

            return phonesClient;

        } catch (DaoExceptions e) {

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
        }

    }

    @Override
    public ArrayList<Address> getAddressClients(Client client) throws Exception {

        String sql = "SELECT address.* FROM client_address JOIN address ON client_address.id_address = address.id WHERE client_address.id_client = ?";

        try {

            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, client.getId());

            resultSet = preparedStatement.executeQuery();

            ArrayList<Address> adressClient = new ArrayList<>();

            while (resultSet.next()) {

                adressClient.add(new Address(resultSet.getInt("id"), resultSet.getString("street_direction"), resultSet.getInt("street_number"),
                resultSet.getString("city"), resultSet.getString("state"), resultSet.getInt("postal_code")));
            }

            return adressClient;

        } catch (DaoExceptions e) {

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
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

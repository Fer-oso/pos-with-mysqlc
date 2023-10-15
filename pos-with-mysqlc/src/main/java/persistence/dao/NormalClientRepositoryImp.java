package persistence.dao;

import entitiys.client.RegularClient;
import interfaces.persistences.repositorys.entitys.clients.normalclient.NormalClientRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.dao.exceptios.DaoExceptions;
import interfaces.entitys.clients.NormalClient;

public class NormalClientRepositoryImp extends DaoRepository implements NormalClientRepository {
    

    @Override
    public void save(NormalClient object) throws Exception {
        
        try {

            String sql = "INSERT INTO clients (name, lastname, age, ssn, clasification ) VALUES (?, ?, ?, ?, ?)";

            // connection = startConnection();
            preparedStatement = startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());

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
    public NormalClient update(Integer id, NormalClient object) throws Exception {
        try {

            String sql = "UPDATE clients SET  name = ?, lastname = ?, age = ?, ssn = ?, clasification = ? WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getLastName());

            preparedStatement.setInt(3, object.getAge());

            preparedStatement.setString(4, object.getSsn());

            preparedStatement.setString(5, object.getClasification());

            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

            connection.commit();

            return findById(id);

        } catch (SQLException e) {

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {

            String sql = "DELETE FROM clients WHERE id = ?";

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
    public NormalClient findById(Integer id) throws Exception {

        try {
            String sql = "SELECT * FROM clients WHERE id = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));
            } else {

                return null;
            }

        } catch (SQLException e) {
            
            rollbackTransaction();
            
            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public NormalClient findBySsn(String ssn) throws Exception{
          try {
            String sql = "SELECT * FROM clients WHERE ssn = ?";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, ssn);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));
            } else {

                return null;
            }

        } catch (SQLException e) {
            
            rollbackTransaction();
            
            throw new DaoExceptions("Error Mysql" + e.getMessage());

        } finally {

            closeConnection();
        }
    }

    @Override
    public List<NormalClient> findAll() throws Exception {

        try {
            String sql = "SELECT * FROM  clients";

            //connection = startConnection();
            preparedStatement = startConnection().prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<NormalClient> normalClients = new ArrayList<>();

            while (resultSet.next()) {

                NormalClient normalClient = new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));

                normalClients.add(normalClient);
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
    public List<NormalClient> findAllByName(String name) throws Exception{
       
        try {
            String sql = "SELECT * FROM  clients WHERE name = ?";

            //connection = startConnection();
            preparedStatement = startConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();

            List<NormalClient> normalClients = new ArrayList<>();

            while (resultSet.next()) {

                NormalClient normalClient = new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));

                normalClients.add(normalClient);
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
    public List<NormalClient> findAllByLastName(String lastName) throws Exception {
         try {
            String sql = "SELECT * FROM  clients WHERE lastname = ?";

            //connection = startConnection();
            preparedStatement = startConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, lastName);

            resultSet = preparedStatement.executeQuery();

            List<NormalClient> normalClients = new ArrayList<>();

            while (resultSet.next()) {

                NormalClient normalClient = new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));

                normalClients.add(normalClient);
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
    public List<NormalClient> findAllByAge(int age) throws Exception {
         try {
            String sql = "SELECT * FROM  clients WHERE age = ?";

            //connection = startConnection();
            preparedStatement = startConnection().prepareStatement(sql);
            
            preparedStatement.setInt(1, age);

            resultSet = preparedStatement.executeQuery();

            List<NormalClient> normalClients = new ArrayList<>();

            while (resultSet.next()) {

                NormalClient normalClient = new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));

                normalClients.add(normalClient);
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
    public List<NormalClient> findAllByClasification(String clasification) throws Exception{
         try {
            String sql = "SELECT * FROM  clients WHERE clasification = ?";

            //connection = startConnection();
            preparedStatement = startConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, clasification);

            resultSet = preparedStatement.executeQuery();

            List<NormalClient> normalClients = new ArrayList<>();

            while (resultSet.next()) {

                NormalClient normalClient = new RegularClient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("ssn"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        resultSet.getString("clasification"));

                normalClients.add(normalClient);
            }

            return normalClients;

        } catch (DaoExceptions e) {

            rollbackTransaction();

            throw new DaoExceptions("SQL ERROR" + e.getMessage());

        } finally {

            closeConnection();
        }

    } 
}

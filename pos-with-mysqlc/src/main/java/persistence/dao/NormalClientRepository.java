package persistence.dao;

import entitiys.client.NormalClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.dao.exceptios.DaoExceptions;

public class NormalClientRepository extends DaoRepository<NormalClient, Integer> {

    @Override
    public void save(NormalClient object) throws Exception {
        try {

            String sql = "INSERT INTO clients (name, lastname, age, ssn, clasification ) VALUES (?, ?, ?, ?, ?)";

            connection = startConnection();

            preparedStatement = connection.prepareStatement(sql);

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

                return new NormalClient(
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
    public List<NormalClient> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

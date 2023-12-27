package persistence.dao;

import entitys.models.product.Product;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import lombok.SneakyThrows;
import persistence.config.DbConnector;
import persistence.dao.exceptios.DaoExceptions;

public class ProductRepositoryImp implements ProductRepository {

    private static final long serialVersionUID = 1L;

    DbConnector dbConnector;

    public ProductRepositoryImp(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    @SneakyThrows
    public Optional <Product> save(Product object){

        try {

            String sql = "INSERT INTO products (`name`, `brand`, `price`, `stock`, `availability`, `product_code`) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getBrand());

            preparedStatement.setDouble(3, object.getPrice());

            preparedStatement.setInt(4, object.getStock());

            preparedStatement.setBoolean(5, object.isAvailabity());

            preparedStatement.setString(6, object.getProductCode());

            preparedStatement.executeUpdate();

            dbConnector.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            Integer idGeneratedKeys = null;

            if (resultSet.next()) {
                
                idGeneratedKeys = resultSet.getInt(1);
            }

            return findById(idGeneratedKeys);

        } catch (Exception e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions("Error en mySQL No object saved " + e.toString());

        } finally {

            dbConnector.closeConnection();
        }
    }
    
    @Override
    @SneakyThrows
    public Optional<Product> findById(Integer id) {

        try {

            String sql = "SELECT * FROM products WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Product product = null;

            if (resultSet.next()) {

                product = new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock"),
                        resultSet.getBoolean("availability"),
                        resultSet.getString("product_code"));
            }

            return Optional.ofNullable(product);

        } catch (Exception e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public Optional<Product> update(Integer id, Product object){

        try {

            String sql = "UPDATE products SET name = ?, brand = ?, price = ?, stock = ?, availability = ?, product_code = ? WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setString(1, object.getName());

            preparedStatement.setString(2, object.getBrand());

            preparedStatement.setDouble(3, object.getPrice());

            preparedStatement.setInt(4, object.getStock());

            preparedStatement.setBoolean(5, object.isAvailabity());

            preparedStatement.setString(6, object.getProductCode());

            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

            return findById(id);

        } catch (Exception e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        try {

            String sql = "DELETE FROM products WHERE id = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (Exception e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    

    @Override
    @SneakyThrows
    public ArrayList<Product> findAll(){

        try {

            String sql = "SELECT * FROM products";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Product> productList = new ArrayList<>();

            while (resultSet.next()) {

                productList.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock"),
                        resultSet.getBoolean("availability"),
                        resultSet.getString("product_code")));
            }

            return productList;

        } catch (Exception e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }

    @SneakyThrows
    @Override
    public Optional<Product> findByProductCode(String productCode) {
         try {

            String sql = "SELECT * FROM products WHERE product_code = ?";

            PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(sql);

            preparedStatement.setString(1, productCode);

            ResultSet resultSet = preparedStatement.executeQuery();

            Product product = null;

            if (resultSet.next()) {

                product = new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock"),
                        resultSet.getBoolean("availability"),
                        resultSet.getString("product_code"));
            }

            return Optional.ofNullable(product);

        } catch (Exception e) {

            dbConnector.rollbackTransaction();

            throw new DaoExceptions(e.getMessage());

        } finally {

            dbConnector.closeConnection();
        }
    }
}

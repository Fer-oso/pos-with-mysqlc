package persistence.dao.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import entitys.models.shop.shoppingcart.ShoppingCart;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.SneakyThrows;
import persistence.config.DbConnector;

public class ShoppingCartRepositoryImp implements ShoppingCartRepository {

    private static final long serialVersionUID = 1L;

    DbConnector dbConnector;

    public ShoppingCartRepositoryImp(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    @SneakyThrows
    public Optional<ShoppingCart> save(ShoppingCart shoppingCart) {

        String shoppingCartToJSONString = new ObjectMapper().writeValueAsString(shoppingCart);

        String query = "INSERT INTO shopping_carts (shopping_cart) VALUES (?)";

        try (PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, shoppingCartToJSONString);

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            Logger.getLogger(ShoppingCartRepositoryImp.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            dbConnector.closeConnection();
        }

        return findById(shoppingCart.getId());
    }

    @Override
    @SneakyThrows
    public Optional<ShoppingCart> update(Integer id, ShoppingCart shoppingCart
    ) {

        String query = "UPDATE shopping_carts SET shopping_cart = ?  WHERE id = ? ";

        try {

            try (PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(query)) {

                String shoppingCartToJSONString = new ObjectMapper().writeValueAsString(shoppingCart);

                preparedStatement.setString(1, shoppingCartToJSONString);

                preparedStatement.executeUpdate();

            }

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            Logger
                    .getLogger(ShoppingCartRepositoryImp.class
                            .getName()).log(Level.SEVERE, null, e);

        } finally {

            dbConnector.closeConnection();
        }

        return findById(shoppingCart.getId());
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        String query = "DELETE * FROM shopping_carts WHERE id = ?";

        try (PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            dbConnector.commit();

        } catch (SQLException e) {

            dbConnector.rollbackTransaction();

            Logger
                    .getLogger(ShoppingCartRepositoryImp.class
                            .getName()).log(Level.SEVERE, null, e);
        } finally {

            dbConnector.closeConnection();
        }
    }

    @Override
    @SneakyThrows
    public Optional<ShoppingCart> findById(Integer id) {

        ShoppingCart shoppingCart = null;

        String query = "SELECT * FROM shopping_carts WHERE JSON_EXTRACT (shopping_cart, '$.id') =  ?";

        try (PreparedStatement preparedStatement = dbConnector.startConnection().prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String jsonToString = resultSet.getString("shopping_cart");

                shoppingCart = new ObjectMapper().readValue(jsonToString, ShoppingCart.class);
            }

        } catch (Exception ex) {

            dbConnector.rollbackTransaction();

            Logger.getLogger(ShoppingCartRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            dbConnector.closeConnection();
        }

        return Optional.ofNullable(shoppingCart);
    }

    @Override
    public ArrayList<ShoppingCart> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

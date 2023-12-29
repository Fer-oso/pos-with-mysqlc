package persistence.dao.persistence;

import entitys.models.shop.ShoppingCart;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;
import java.util.ArrayList;
import java.util.Optional;
import persistence.config.DbConnector;

public class ShoppingCartRepositoryImp implements ShoppingCartRepository{

    private static final long serialVersionUID = 1L;
    
     DbConnector dbConnector;

    public ShoppingCartRepositoryImp(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }
     
    @Override
    public Optional<ShoppingCart> save(ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ShoppingCart> update(Integer id, ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ShoppingCart> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ShoppingCart> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
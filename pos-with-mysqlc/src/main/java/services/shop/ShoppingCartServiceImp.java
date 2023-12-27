package services.shop;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import entitys.models.shop.ShoppingCart;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;

import interfaces.services.ShoppingCartService;
import java.util.ArrayList;


public class ShoppingCartServiceImp implements ShoppingCartService {

    private static final long serialVersionUID = 1L;

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImp(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCart createShoppingCart(Client client, ArrayList<SelectedProduct> listSelectedProducts,Double total){
    
    return new ShoppingCart(client, listSelectedProducts, total);
    
    }

    @Override
    public ShoppingCart save(ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ShoppingCart update(Integer id, ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ShoppingCart> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ShoppingCart findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkDuplicateRegister(ShoppingCart t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


  

}

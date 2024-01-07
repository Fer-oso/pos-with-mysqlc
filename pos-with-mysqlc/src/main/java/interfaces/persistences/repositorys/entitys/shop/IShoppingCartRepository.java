package interfaces.persistences.repositorys.entitys.shop;

import entitys.models.shop.shoppingcart.ShoppingCart;
import interfaces.persistences.crud.CrudRepository;

public interface IShoppingCartRepository<T extends ShoppingCart, ID> extends CrudRepository<T, ID> {
    
}

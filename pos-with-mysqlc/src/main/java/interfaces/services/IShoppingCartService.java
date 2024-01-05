package interfaces.services;

import entitys.models.shop.ShoppingCart;
import interfaces.persistences.crud.Save;
import interfaces.persistences.repositorys.FindById;
import java.io.Serializable;

public interface IShoppingCartService<T extends ShoppingCart,ID> extends Save<T>,FindById<T, ID>, Serializable{
}

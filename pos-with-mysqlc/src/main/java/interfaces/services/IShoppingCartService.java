package interfaces.services;

import entitys.models.shop.ShoppingCart;

import interfaces.services.crud.CrudService;

public interface IShoppingCartService<T extends ShoppingCart,ID> extends CrudService<T, ID>{

}

package services.products;

import entitiys.models.product.Product;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import interfaces.services.ProductService;
import java.util.ArrayList;
import java.util.Optional;

public class ProductServiceImp implements ProductService{

    private static final long serialVersionUID = 1L;
    
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Product save(Product object) throws Exception {
        
        try {
            return productRepository.save(object);
        } catch (Exception e) {
            
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product update(Integer id, Product object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Product> findById(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Product> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
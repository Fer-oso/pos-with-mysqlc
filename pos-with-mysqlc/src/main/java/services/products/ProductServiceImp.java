package services.products;

import entitys.models.product.Product;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import interfaces.services.ProductService;
import java.util.ArrayList;
import lombok.SneakyThrows;
import services.exceptions.ProductServiceException;

public class ProductServiceImp implements ProductService {

    private static final long serialVersionUID = 1L;

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    @SneakyThrows
    public Product save(Product object) {

        if (checkDuplicateRegister(object)) {

            throw new ProductServiceException("Cant duplicate registers, that product already registered with product_code " + object.getProductCode());

        } else {

            return productRepository.save(object).orElseThrow();
        }
    }

    @Override
    @SneakyThrows
    public Product findById(Integer id) {

        return productRepository.findById(id).orElseThrow(() -> new ProductServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public Product update(Integer id, Product object) {

        return productRepository.update(id, object).orElseThrow(() -> new ProductServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductServiceException("No value present with that id"));

        productRepository.delete(product.getId());
    }

    @Override
    @SneakyThrows
    public ArrayList<Product> findAll() {
        
        return productRepository.findAll();
    }

    @Override
    public boolean checkDuplicateRegister(Product product) {

        return findAll().stream().anyMatch(t -> {

            return (t.getName().equalsIgnoreCase(product.getName())
                    && t.getBrand().equalsIgnoreCase(product.getBrand())
                    && t.getProductCode().equalsIgnoreCase(product.getProductCode()));
        });
    }

    @Override
    @SneakyThrows
    public Product findByProductCode(String productCode) {
        
        return productRepository.findByProductCode(productCode).orElse(null);
    }
}

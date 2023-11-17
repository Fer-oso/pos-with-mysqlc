package services.products;

import entitiys.models.product.Product;
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

    Product product;

    @Override
    @SneakyThrows
    public Product save(Product object) {

        if (checkDuplicate(object)) {

            throw new ProductServiceException("Cant duplicate registers, that product already registered with product_code " + product.getProductCode());

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

       // findById(id);

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

        try {

            if (productRepository.findAll().isEmpty()) {

                throw new ProductServiceException("empty list");
            }

        } catch (ProductServiceException e) {

            System.out.println(e.getMessage());
        }

        return productRepository.findAll();
    }

    private boolean checkDuplicate(Product object) {

        return findAll().stream().anyMatch(t -> {

            product = t;

            return (t.getName().equalsIgnoreCase(object.getName())
                    && t.getBrand().equalsIgnoreCase(object.getBrand())
                    && t.getProductCode().equalsIgnoreCase(object.getProductCode()));
        });
    }
}

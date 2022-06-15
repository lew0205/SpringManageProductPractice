package com.mp.manage.product.Service;

import com.mp.manage.product.Repository.ProductRepository;
import com.mp.manage.product.domain.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long joinProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public List<Product> findByName(String name) {
        return productRepository.findAllByName(name);
    }
}

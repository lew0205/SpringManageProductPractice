package com.mp.manage.product.service;

import com.mp.manage.product.domain.dto.ProductDto;
import com.mp.manage.product.repository.ProductRepository;
import com.mp.manage.product.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long join(ProductDto productDto) {
        Product product = productDto.toEntity();
        productRepository.save(product);
        return product.getId();
    }

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}

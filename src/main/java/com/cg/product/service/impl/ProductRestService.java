package com.cg.product.service.impl;

import com.cg.product.model.Product;
import com.cg.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRestService {
    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    public Product save(Product product) {
        return iProductRepository.save(product);
    }
}

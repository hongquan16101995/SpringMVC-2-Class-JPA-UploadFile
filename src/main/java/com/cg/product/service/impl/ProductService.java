package com.cg.product.service.impl;

import com.cg.product.model.Product;
import com.cg.product.repository.IProductRepository;
import com.cg.product.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements ICrudService<Product, Long> {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findOne(Long aLong) {
        return iProductRepository.findById(aLong);
    }

    @Override
    public void deleteByID(Long aLong) {
        iProductRepository.deleteById(aLong);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name, pageable);
    }
}

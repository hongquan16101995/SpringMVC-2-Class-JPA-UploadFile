package com.cg.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICrudService<E, ID> {
    Page<E> findAll(Pageable pageable);

    Page<E> findByName(String name, Pageable pageable);

    void save(E e);

    Optional<E> findOne(ID id);

    void deleteByID(ID id);
}

package com.cg.product.service;

import com.cg.product.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findCategories();
}

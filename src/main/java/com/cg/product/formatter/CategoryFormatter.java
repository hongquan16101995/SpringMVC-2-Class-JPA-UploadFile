package com.cg.product.formatter;

import com.cg.product.model.Category;
import com.cg.product.service.ICrudService;
import org.springframework.format.Formatter;

import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {
    private final ICrudService<Category, Long> iCrudService;

    public CategoryFormatter(ICrudService<Category, Long> iCrudService) {
        this.iCrudService = iCrudService;
    }

    @Override
    public Category parse(String text, Locale locale) {
        Optional<Category> category = iCrudService.findOne(Long.parseLong(text));
        return category.orElseGet(Category::new);
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}

package com.cg.product.controller;

import com.cg.product.model.Category;
import com.cg.product.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICrudService<Category, Long> iCrudService;

    @GetMapping
    public ModelAndView listCategories(@PageableDefault(size = 3) Pageable pageable,
                                       @RequestParam("search") Optional<String> name) {
        ModelAndView modelAndView = new ModelAndView("category/list");
        if (!name.isPresent()) {
            modelAndView.addObject("categories", iCrudService.findAll(pageable));
        } else {
            modelAndView.addObject("categories", iCrudService.findByName(name.get(), pageable));
            modelAndView.addObject("search", name.get());
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("category/form");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("category/form");
        Optional<Category> category = iCrudService.findOne(id);
        if (category.isPresent()) {
            modelAndView.addObject("category", category.get());
        } else {
            return new ModelAndView("404");
        }
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category) {
        iCrudService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        iCrudService.deleteByID(id);
        return "redirect:/categories";
    }
}

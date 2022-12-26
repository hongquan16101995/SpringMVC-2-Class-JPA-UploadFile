package com.cg.product.controller;

import com.cg.product.model.Product;
import com.cg.product.service.ICrudService;
import com.cg.product.service.impl.ProductRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class HomeController {
    @Autowired
    private ProductRestService productRestService;

    @Autowired
    private ICrudService<Product, Long> iCrudService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
       List<Product> productList = productRestService.findAll();
       return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/page")
    public ResponseEntity<Page<Product>> findAllPage(@PageableDefault(size = 3)Pageable pageable) {
        Page<Product> productList = iCrudService.findAll(pageable);
       return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> creat(@RequestBody Product product) {
        Product productCreated = productRestService.save(product);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }
}

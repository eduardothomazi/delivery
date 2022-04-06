package com.eduardo.delivery.controllers;

import com.eduardo.delivery.entities.dto.ProductDTO;
import com.eduardo.delivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> dtoList = service.findAllByOrderByNameAsc();
        return ResponseEntity.ok().body(dtoList);
    }
}

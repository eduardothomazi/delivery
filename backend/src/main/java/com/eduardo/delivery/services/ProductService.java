package com.eduardo.delivery.services;

import com.eduardo.delivery.entities.Product;
import com.eduardo.delivery.entities.dto.ProductDTO;
import com.eduardo.delivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllByOrderByNameAsc(){
        List<Product> productList = repository.findAllByOrderByNameAsc();
        List<ProductDTO> dtoList = productList.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
        return dtoList;
    }
}

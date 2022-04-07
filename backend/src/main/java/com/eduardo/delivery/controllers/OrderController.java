package com.eduardo.delivery.controllers;

import com.eduardo.delivery.entities.Order;
import com.eduardo.delivery.entities.dto.OrderDTO;
import com.eduardo.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> dtoList = service.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

}

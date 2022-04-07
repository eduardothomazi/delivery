package com.eduardo.delivery.controllers;

import com.eduardo.delivery.entities.dto.OrderDTO;
import com.eduardo.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @RequestMapping(value = "/{id}/delivered", method = RequestMethod.PUT)
    public ResponseEntity<OrderDTO> setStatus(@PathVariable Long id){
        OrderDTO dto = service.setDelivered(id);
        return ResponseEntity.ok().body(dto);
    }

}

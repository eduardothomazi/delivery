package com.eduardo.delivery.services;

import com.eduardo.delivery.entities.Order;
import com.eduardo.delivery.entities.dto.OrderDTO;
import com.eduardo.delivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> orderList = repository.findOrdersWithProducts();
        List<OrderDTO> dtoList = orderList.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
        return dtoList;
    }

}

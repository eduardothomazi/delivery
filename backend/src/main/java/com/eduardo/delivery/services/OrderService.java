package com.eduardo.delivery.services;

import com.eduardo.delivery.entities.Order;
import com.eduardo.delivery.entities.Product;
import com.eduardo.delivery.entities.dto.OrderDTO;
import com.eduardo.delivery.entities.dto.ProductDTO;
import com.eduardo.delivery.entities.enums.OrderStatus;
import com.eduardo.delivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Arrays;
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

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING.getValue());
        repository.save(order);
         order.getProducts().addAll(dto.getProducts().stream().map(x -> new Product(x)).collect(Collectors.toList()));
        return new OrderDTO(order);

    }

}

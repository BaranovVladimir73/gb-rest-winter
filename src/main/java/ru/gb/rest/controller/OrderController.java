package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.rest.dto.ProductDto;
import ru.gb.rest.dto.ProductManufacturerDto;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.OrderGateway;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderGateway orderGateway;

    @GetMapping("/get-order/{orderId}")
    public List<ProductManufacturerDto> getOrderFromOrderList(@PathVariable("orderId") int id){
        return orderGateway.getOrderFromOrderList(id);
    }
}

package ru.gb.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.rest.dto.ProductDto;
import ru.gb.rest.dto.ProductManufacturerDto;
import ru.gb.rest.entity.Product;

import java.util.List;

@FeignClient(url = "localhost:8787/order", value = "orderGateway")
public interface OrderGateway {

    @GetMapping("/get-order/{orderId}")
    List<ProductManufacturerDto> getOrderFromOrderList(@PathVariable("orderId") int id);

}

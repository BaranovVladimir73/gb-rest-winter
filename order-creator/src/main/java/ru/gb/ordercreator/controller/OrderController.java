package ru.gb.ordercreator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.ordercreator.dao.Order;

import ru.gb.ordercreator.dto.ProductManufacturerDto;
import ru.gb.ordercreator.service.OrderListService;
import ru.gb.ordercreator.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderListService orderListService;

    @GetMapping
    public List<ProductManufacturerDto> showAllProductInOrder(){
        return orderService.showOrder();
    }

    @GetMapping("/add/{productId}")
    public ResponseEntity<?> addProductInOrder(@PathVariable("productId") Long id){
        orderService.addProductToOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProductFromOrder(@PathVariable("productId") int id){
        orderService.deleteProductFromOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/create-order")
    public ResponseEntity<?> createOrder(){
        Order order = orderService.getOrder();
        orderListService.createNewOrderInList(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list-orders")
    public List<Order> showAllOrders(){
        return orderListService.showAllOrders();
    }

    @DeleteMapping("/delete-order/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderId") int id){
        orderListService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/change-order/{orderId}")
    public ResponseEntity<?> changeOrder(@PathVariable("orderId") int id){
        orderListService.changeOrderById(id, orderService.getOrder());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-order/{orderId}")
    public List<ProductManufacturerDto> getOrderFromOrderList(@PathVariable("orderId") int id){
        return orderListService.showOrderById(id);
    }


}

package ru.gb.ordercreator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.ordercreator.dao.Order;
import ru.gb.ordercreator.dao.OrderList;
import ru.gb.ordercreator.dto.ProductManufacturerDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderListService {

    private final OrderList orderList;

    public void createNewOrderInList(Order order){
        orderList.addNewOrder(order);
    }

    public List<Order> showAllOrders(){
        return orderList.getListOfOrders();
    }

    public void deleteOrderById(int id){
        orderList.deleteOrderById(id);
    }

    public void changeOrderById(int id, Order order){
        orderList.changeOrderById(id, order);
    }

    public List<ProductManufacturerDto> showOrderById(int id){
        return orderList.showOrderById(id);
    }


}

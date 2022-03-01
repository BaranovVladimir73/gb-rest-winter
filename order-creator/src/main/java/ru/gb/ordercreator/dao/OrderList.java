package ru.gb.ordercreator.dao;

import org.springframework.stereotype.Repository;
import ru.gb.ordercreator.dto.ProductManufacturerDto;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderList {

    private List<Order> listOfOrders = new ArrayList<>();

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }


    public void addNewOrder(Order order){
        listOfOrders.add(order);
    }

    public void deleteOrderById(int id){
        listOfOrders.remove(id-1);
    }

    public void changeOrderById(int id, Order order){
        listOfOrders.remove(id-1);
        listOfOrders.add(id-1, order);
    }

    public List<ProductManufacturerDto> showOrderById(int id){
        return listOfOrders.get(id-1).getOrderList();
    }


}

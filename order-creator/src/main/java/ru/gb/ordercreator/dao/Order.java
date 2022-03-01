package ru.gb.ordercreator.dao;

import org.springframework.stereotype.Repository;
import ru.gb.ordercreator.dto.ProductManufacturerDto;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Order {

    private List<ProductManufacturerDto> orderList = new ArrayList<>();

    public void addProduct(ProductManufacturerDto productDto){
        orderList.add(productDto);
        System.out.println(orderList.toString());
    }



    public void deleteProductById(int id){

        orderList.remove(id-1);

    }

    public List<ProductManufacturerDto> getOrderList(){
        return orderList;
    }

    public void deleteAllProduct(){
        orderList.clear();
    }
}

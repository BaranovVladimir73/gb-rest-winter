package ru.gb.ordercreator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.ordercreator.dao.Order;
import ru.gb.ordercreator.dao.ProductDao;
import ru.gb.ordercreator.dto.ProductManufacturerDto;
import ru.gb.ordercreator.dto.mapper.ProductMapper;
import ru.gb.ordercreator.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {


    private final Order order;
    private final ProductDao productDao;
    private final ProductMapper productMapper;


    public void addProductToOrderById(Long id){
        Product product = productDao.findById(id).orElse(null);
        ProductManufacturerDto productDto = productMapper.toProductManufacturerDto(product);
        order.addProduct(productDto);
    }

    public List<ProductManufacturerDto> showOrder(){
        return order.getOrderList();
    }

    public void deleteProductFromOrder(int id){
        order.deleteProductById(id);
    }

    public Order getOrder() {
        return order;
    }

}

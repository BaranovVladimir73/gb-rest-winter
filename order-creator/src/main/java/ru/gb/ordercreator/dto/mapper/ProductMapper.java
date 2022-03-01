package ru.gb.ordercreator.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.ordercreator.dao.ManufacturerDao;
import ru.gb.ordercreator.dto.ProductDto;
import ru.gb.ordercreator.dto.ProductManufacturerDto;
import ru.gb.ordercreator.entity.Manufacturer;
import ru.gb.ordercreator.entity.Product;


import java.util.NoSuchElementException;

@Mapper(uses = ManufacturerMapper.class)
public interface ProductMapper {
    Product toProduct(ProductDto productDto, @Context ManufacturerDao manufacturerDao);

    ProductDto toProductDto(Product product);

    @Mapping(source = "manufacturer", target = "manufacturerDto")
    ProductManufacturerDto toProductManufacturerDto(Product product);

    default String getManufacturer(Manufacturer manufacturer) {
        return manufacturer.getName();
    }

    default Manufacturer getManufacturer(String manufacturer, @Context ManufacturerDao manufacturerDao) {
        return manufacturerDao.findByName(manufacturer).orElseThrow(NoSuchElementException::new);
    }
}

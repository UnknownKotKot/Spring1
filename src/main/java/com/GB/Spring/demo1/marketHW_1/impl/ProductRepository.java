package com.GB.Spring.demo1.marketHW_1.impl;

import com.GB.Spring.demo1.marketHW_1.obj.Product;
import com.GB.Spring.demo1.marketHW_1.api.IProductRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("singleton")
public class ProductRepository implements IProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 85),
                new Product(2L, "Bread", 25),
                new Product(3L, "Meat", 125),
                new Product(4L, "Aqua", 15),
                new Product(5L, "Paper", 5)
        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }


}

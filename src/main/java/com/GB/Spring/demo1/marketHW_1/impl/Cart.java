package com.GB.Spring.demo1.marketHW_1.impl;

import com.GB.Spring.demo1.marketHW_1.obj.Product;
import com.GB.Spring.demo1.marketHW_1.api.ICart;
import com.GB.Spring.demo1.marketHW_1.api.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart implements ICart {
    private IProductRepository productRepository;
    private List<Product> cartList;

    @Autowired
    public void setProductRepository(@Qualifier(value = "productRepository") IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        cartList = new ArrayList<>();
    }

    @Override
    public void addProduct(Long id) {
        cartList.add(productRepository.findById(id));
    }

    @Override
    public void removeProduct(Long id) {
        cartList.remove(productRepository.findById(id));
    }

    public void showCart() {
        if(cartList.isEmpty())System.out.println("Cart is empty!");
        for (Product p : cartList) {
            System.out.println(p);
        }
    }
}

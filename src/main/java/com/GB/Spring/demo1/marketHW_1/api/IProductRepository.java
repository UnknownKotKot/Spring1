package com.GB.Spring.demo1.marketHW_1.api;

import com.GB.Spring.demo1.marketHW_1.obj.Product;

import java.util.List;

public interface IProductRepository {
    Product findById(Long id);
    List<Product> findAll();
}

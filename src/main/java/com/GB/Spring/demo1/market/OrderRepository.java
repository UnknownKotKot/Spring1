package com.GB.Spring.demo1.market;

import org.springframework.stereotype.Component;

@Component
public interface OrderRepository {
    void save(Order order);
}

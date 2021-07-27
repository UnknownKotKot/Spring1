package com.GB.Spring.demo1.market;

import org.springframework.stereotype.Component;

@Component
public interface UserRepository {
    User findByUsername(String username);

}

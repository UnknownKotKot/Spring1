package com.GB.Spring.demo1.market;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User findByUsername(String username);
}

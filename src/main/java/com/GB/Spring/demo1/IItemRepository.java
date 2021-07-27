package com.GB.Spring.demo1;

import java.util.List;

public interface IItemRepository {
     Item findById(Long id);
     List<Item> findAll();
     void save(Item item);
}

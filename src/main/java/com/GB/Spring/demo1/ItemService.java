package com.GB.Spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    //необходимо привязать ItemRepository из контекста

    //1 способ - самый не предпочтительный
   // @Autowired // спринг заинжектил из контекста
    private IItemRepository itemRepository;
    //спринг может считать бинами любые поля
    @Value("12312312")//когда бин будет создан, поле будет проиницилаизировано с таким значением
    private  String itemsInternalCode /*= "12312312"*/;//не рекомендуецтся итнициализироват ьв онстурторах поля и в таком виде


    //2 cпособо - создание сеттера для поля + аннотация
    @Autowired
    public void setItemRepository(@Qualifier(value = "inMemoryItemRepository") IItemRepository itemRepository) {
        //аннотация которая помогает указать нужный бин для инъекции из наследников интерфейса
        this.itemRepository = itemRepository;
    }

    //3 вариант - инъекция через констурктор с аннотацией
    //@Autowired // надо конструктором она работает неявно - но улчше ставить дял наглоядности
   /* public ItemService(@Qualifier(value = "inMemoryItemRepository")IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }*/

    public int getSumPrice() {
        return itemRepository.findAll().stream().mapToInt(Item::getPrice).sum();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

}

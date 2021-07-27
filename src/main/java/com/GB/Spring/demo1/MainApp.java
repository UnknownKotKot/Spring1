package com.GB.Spring.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//аннтотация что это конфигурациооный файл
@ComponentScan("com.GB.Spring.demo1")//анонтация указыет где лежат бины для скаинрования со вложенными пакетами
public class MainApp {
    public static void main(String[] args) {
        //в скобках конфигурационный класс для контекста - аннотация для спринга @Configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
      /*
        //вытаскиваем объект Box из контекста
        Box box1 = context.getBean(Box.class);//контекст дай нам ссылку на бокс
        Box box2 = context.getBean(Box.class);// в данном случае будет тот же объект, а не новый
        //для создания нового нужна аннотация @Scope
        //объексты который управляются контекстом - называются бинами
        //чтобы спринг мог создать объект. то у объектов должен быть дефолтный контсруктор
        box1.setColor("green");
        System.out.println(box1);
        System.out.println(box2);*/


        ItemService itemService = context.getBean(ItemService.class);
        System.out.println(itemService.getSumPrice());

        /*itemService.save(new Item ( null, "Meat", 100));
        System.out.println(itemService.findAll());
        System.out.println(itemService.findById(1L));*/


        context.close();//закрывает все соединения(обычно это парвило хорошего тона + обязательно для веба)

    }
}

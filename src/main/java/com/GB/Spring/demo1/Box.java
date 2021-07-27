package com.GB.Spring.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//чтобы спринг сам создал объект по этому классу ставим аннотацию
@Component
@Scope("prototype")
//аннотация @Scope("prototype") - указывает спрингу что надо создавать новые экземпляры объектов
//аннотация @Scope("singleton") - указывает спрингу что надо создавать только один объект для всего контекста - если аннотации вообщенет, то по дефолту синглтон

public class Box {
    private String color = "red";
    private int size = 4;

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}

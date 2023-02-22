package com.example.onlineshop.ds;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@EqualsAndHashCode
public class Item {
    private @Id String id;
    private String name;
    private double price;

    public Item(){

    }
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

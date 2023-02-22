package com.example.onlineshop.server;

import com.example.onlineshop.ds.Dish;
import com.example.onlineshop.service.KitchenService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


public class KitchenServer {
    private final KitchenService kitchenService;

    public KitchenServer(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }
    Flux<Dish> doingMyJob(){
        return this.kitchenService.getDishes()
                .map(dish -> Dish.deliver(dish));
    }
}

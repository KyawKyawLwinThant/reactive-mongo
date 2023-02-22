package com.example.onlineshop.controller;

import com.example.onlineshop.ds.Dish;
import com.example.onlineshop.service.KitchenService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
public class ServerController {

    private final KitchenService kitchen;

    public ServerController(KitchenService kitchen) {
        this.kitchen = kitchen;
    }
    @GetMapping(value = "/server",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> serveDishes(){
        return this.kitchen.getDishes();
    }


}

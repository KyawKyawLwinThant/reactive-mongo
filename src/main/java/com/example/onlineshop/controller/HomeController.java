package com.example.onlineshop.controller;

import com.example.onlineshop.dao.CartRepository;
import com.example.onlineshop.dao.ItemRepository;
import com.example.onlineshop.ds.Cart;
import com.example.onlineshop.ds.CartItem;
import com.example.onlineshop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {


    private final CartService cartService;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public HomeController(CartService cartService, CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @PostMapping("/add/{id}")
    public Mono<String> addToCart(@PathVariable String id){
        return this.cartService.addToCart("My Cart",id)
                .thenReturn("redirect:/");
    }

    @GetMapping("/")
    public Mono<Rendering> home() {
        return Mono.just(Rendering.view("home.html")
                .modelAttribute("items", this.itemRepository
                        .findAll())
                .modelAttribute("cart", this.cartRepository
                        .findById("My Cart")
                        .defaultIfEmpty(new Cart("My Cart")))
                .build());


    }
}

package com.example.onlineshop.server;

import com.example.onlineshop.service.KitchenService;

public class Main {
    public static void main(String[] args) {
        PoliteServer server=
                new PoliteServer(new KitchenService());
        server.doingMyJob()
                .subscribe( dish -> System.out.println("Consuming "+ dish),
                        throwable -> System.out.println(throwable));
    }
}

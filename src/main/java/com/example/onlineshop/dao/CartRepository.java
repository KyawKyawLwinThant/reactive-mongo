package com.example.onlineshop.dao;

import com.example.onlineshop.ds.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<Cart,String> {
}

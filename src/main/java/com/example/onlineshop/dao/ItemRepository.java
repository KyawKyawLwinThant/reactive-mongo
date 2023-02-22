package com.example.onlineshop.dao;

import com.example.onlineshop.ds.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item,String> {
}

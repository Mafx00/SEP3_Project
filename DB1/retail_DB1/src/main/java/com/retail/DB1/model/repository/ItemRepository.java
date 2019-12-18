package com.retail.DB1.model.repository;

import com.retail.DB1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByName(String name);

    List<Item> findAll();
}

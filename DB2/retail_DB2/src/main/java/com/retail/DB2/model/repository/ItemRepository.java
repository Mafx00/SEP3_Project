package com.retail.DB2.model.repository;

import com.retail.DB2.model.StoredItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<StoredItem, Integer> {

    List<StoredItem> findAllByName(String name);

    List<StoredItem> findAll();
}

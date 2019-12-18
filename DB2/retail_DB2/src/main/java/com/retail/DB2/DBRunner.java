package com.retail.DB2;

import com.retail.DB2.model.StoredItem;
import com.retail.DB2.model.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBRunner implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public DBRunner(ItemRepository itemRepository){this.itemRepository = itemRepository; }


    @Override
    public void run(String... args) throws Exception {

        StoredItem item = new StoredItem(2132, "Car", "It is a car", 2);

        itemRepository.save(item);

       // List<Item> itemList = itemRepository.findAll();

    }
    public List<StoredItem> findAll()
    {
        return itemRepository.findAll();
    }
}

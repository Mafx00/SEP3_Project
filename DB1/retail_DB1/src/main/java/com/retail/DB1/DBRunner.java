package com.retail.DB1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.DB1.model.Account;
import com.retail.DB1.model.Item;
import com.retail.DB1.model.Order;
import com.retail.DB1.model.repository.AccountRepository;
import com.retail.DB1.model.repository.ItemRepository;
import com.retail.DB1.model.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBRunner implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

    public DBRunner(ItemRepository itemRepository, AccountRepository accountRepository, OrderRepository orderRepository){this.itemRepository = itemRepository;
        this.accountRepository = accountRepository;

        this.orderRepository = orderRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Item item = new Item(3155431, "frdf", "It is a plain box");
        Account account = new Account("carl", "behind wall", true);
        //accountRepository.save(account);

        Order order = new Order("listOfItemsToOrder", "resultOfOrder", "Carl");
        //orderRepository.save(order);

        //itemRepository.save(item);

        //List<Item> itemList = itemRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(item));
        System.out.println(objectMapper.writeValueAsString(account));
        System.out.println(objectMapper.writeValueAsString(order));


        String jsonItem = objectMapper.writeValueAsString(itemRepository.findAll());
        System.out.println(jsonItem);

    }
    public List<Item> findAllItems()
    {
        return itemRepository.findAll   ();
    }
}

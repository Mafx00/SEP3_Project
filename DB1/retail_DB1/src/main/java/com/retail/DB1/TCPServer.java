package com.retail.DB1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.DB1.communication.Request;
import com.retail.DB1.model.Account;
import com.retail.DB1.model.Item;
import com.retail.DB1.model.Order;
import com.retail.DB1.model.repository.AccountRepository;
import com.retail.DB1.model.repository.ItemRepository;
import com.retail.DB1.model.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



@Component
public class TCPServer implements CommandLineRunner {

    private final ItemRepository itemRepository;

    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

    public TCPServer(ItemRepository itemRepository, AccountRepository accountRepository, OrderRepository orderRepository){
        this.itemRepository = itemRepository;
        this.accountRepository = accountRepository;
        this.orderRepository = orderRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        final int PORT = 8084;

        ServerSocket welecomeSocket = new ServerSocket(PORT);

        ObjectMapper objectMapper = new ObjectMapper();

        while (true)
        {

            Socket socket = welecomeSocket.accept();


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            String jsonRequest = in.readLine();

            Request request = objectMapper.readValue(jsonRequest, Request.class);



            switch (request.getRequest())
            {
                case "allitems":

                    System.out.println("itemlist");

                    try {
                        out.println(objectMapper.writeValueAsString(itemRepository.findAll()));

                        System.out.println(objectMapper.writeValueAsString(itemRepository.findAll()));
                    }
                    catch (Exception e)
                    {
                        out.print("Error: Database error");
                    }
                    break;

                case "newitem":
                    System.out.println("newitem");

                    Item item = objectMapper.readValue(request.getRequest(), Item.class);
                    try{
                        itemRepository.save(item);
                        out.println("Item Added");
                    }
                    catch (Exception e)
                    {
                        out.print("Error: Database error");
                    }
                    break;

                case "login":
                    System.out.println("login");

                    try {
                        Account account = accountRepository.findAccountByLogin(request.getJson());
                        if (account == null)
                        {
                            out.print("0,0");
                        }
                        else{
                            if (account.isAccountType() == true) {
                                out.println("1,1");
                            } else {
                                out.println("1,0");
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        out.print("Error: Database error");
                    }
                    break;

                case "newaccount":
                    System.out.println("newaccount");

                    Account account1 = objectMapper.readValue(request.getRequest(), Account.class);
                    try
                    {
                        accountRepository.save(account1);
                    }
                    catch(Exception e)
                    {
                        out.print("Error: Database error");
                    }
                    break;

                case "neworder":
                    System.out.println("neworder");

                    Order backorder = objectMapper.readValue(request.getRequest(), Order.class);
                    try
                    {
                        orderRepository.save(backorder);
                        out.println(backorder.getOrderInfo());
                    }
                    catch (Exception e)
                    {
                        out.print("Error: Database error");
                    }
                    break;
            }
        }
    }
}

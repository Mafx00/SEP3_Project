package com.retail.headquarters.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.headquarters.connection.Request;
import com.retail.headquarters.connection.TCPClient;
import com.retail.headquarters.connection.WarehouseConnection;
import com.retail.headquarters.model.Item;
import com.retail.headquarters.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/order")
public class HQOrderController {

    private final Logger logger = LoggerFactory.getLogger(HQItemController.class);
    private TCPClient tcpClient;

    public HQOrderController(){

    }

    @RequestMapping(method = RequestMethod.POST, value = "/neworder")
    public String newOrder(@RequestBody Order order) throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();
        WarehouseConnection warehouseConnection = new WarehouseConnection();
        String backOrder = objectMapper.writeValueAsString(warehouseConnection.placeOrder(order));

        Request request = new Request();
        request.setRequest("neworder");
        request.setJson(backOrder);
        return tcpClient.connectToDB1(request);
    }



}

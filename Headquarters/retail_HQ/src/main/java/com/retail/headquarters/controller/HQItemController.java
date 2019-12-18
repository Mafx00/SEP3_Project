package com.retail.headquarters.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.headquarters.connection.Request;
import com.retail.headquarters.connection.TCPClient;
import com.retail.headquarters.connection.WarehouseConnection;
import com.retail.headquarters.model.Item;
import com.retail.headquarters.model.WarehouseItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/item")
public class HQItemController {

    private final Logger logger = LoggerFactory.getLogger(HQItemController.class);
    private TCPClient tcpClient;

    public HQItemController() {

    }
    @RequestMapping("/allitems")
    public String getAllItems() throws IOException {
        Request request = new Request();
        request.setRequest("allitems");
        request.setJson("empty");
        return tcpClient.connectToDB1(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/newitem")
    public String addItem(@RequestBody Item item) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request();
        request.setRequest("newitem");
        request.setJson(objectMapper.writeValueAsString(item));
        try{
            return tcpClient.connectToDB1(request);
        }
        catch (IOException e)
        {
            return "Database Server error";
        }

    }

    @RequestMapping("/allstockeditems")
    public String getAllStockedItems() throws IOException
    {
        WarehouseConnection warehouseConnection = new WarehouseConnection();
        return warehouseConnection.getAllStackeditems();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/restock")
    public void restock(@RequestBody WarehouseItem warehouseItem) throws IOException
    {
        WarehouseConnection warehouseConnection = new WarehouseConnection();
        warehouseConnection.resupply(warehouseItem);

    }






}

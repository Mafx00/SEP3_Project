package com.retail.headquarters.connection;


import com.retail.headquarters.model.Order;
import com.retail.headquarters.model.WarehouseItem;
import org.springframework.web.client.RestTemplate;

public class WarehouseConnection {

    public WarehouseConnection() {

    }

    public String getAllStackeditems() {
        final String uri = "https://localhost:44343/warehouse/getall";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    public void resupply(WarehouseItem warehouseItem) {
        final String uri = "https://localhost:44343/warehouse/restock";

        RestTemplate restTemplate = new RestTemplate();
        String item = restTemplate.postForObject(uri, warehouseItem, String.class);
        System.out.println(item);
    }
    public Order placeOrder(Order order)
    {
        final String uri = "https://localhost:44343/warehouse/checkOrder";
        RestTemplate restTemplate = new RestTemplate();
        Order finishedOrder = restTemplate.postForObject(uri, order, Order.class);
        return finishedOrder;

    }

}

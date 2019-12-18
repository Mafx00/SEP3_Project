package com.retail.headquarters.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.headquarters.connection.Request;
import com.retail.headquarters.connection.TCPClient;
import com.retail.headquarters.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/account")

public class HQAccountController {

    private final Logger logger = LoggerFactory.getLogger(HQItemController.class);
    private TCPClient tcpClient;

    public HQAccountController() {


    }
    @RequestMapping("/login")
    public String login(@RequestParam(required = true) String login) throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request();
        request.setRequest("login");
        request.setJson(login);
        return tcpClient.connectToDB1(request);

    }
    @RequestMapping(method = RequestMethod.POST, value = "/newaccount")
    public String addItem(@RequestBody Account account) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request();
        request.setRequest("newaccount");
        request.setJson(objectMapper.writeValueAsString(account));
        return tcpClient.connectToDB1(request);
    }
}

package com.retail.headquarters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.headquarters.connection.Request;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;

@Component
public class Test implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        final int PORT = 8084;
        //change host
        final String HOST = "localhost";
        //private String HOST = "206.189.31.131";

        System.out.println("waaa");

        Socket socket = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outof = new PrintWriter(socket.getOutputStream(), true);

        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request("allitems", "empty");

        String jsonRequest = objectMapper.writeValueAsString(request);

        System.out.println(jsonRequest);
        outof.println(jsonRequest);
        String reply = in.readLine();

        System.out.println("ffa");
        System.out.println(reply);
        socket.close();

    }
}

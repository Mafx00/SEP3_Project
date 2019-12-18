package com.retail.headquarters.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TCPClient  {

    private int PORT = 8084;
    //change host
    private String HOST = "localhost";
    //private String HOST = "206.189.31.131";

    public TCPClient() throws IOException {
        this.HOST= "206.189.31.131";
        this.PORT= 8084;
    }
public String connectToDB1(Request request) throws IOException {

        Socket socket = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonRequest =objectMapper.writeValueAsString(request);


        out.println(jsonRequest);
        String reply = in.readLine();

        socket.close();
        System.out.println(reply);
        return reply;


    }
}

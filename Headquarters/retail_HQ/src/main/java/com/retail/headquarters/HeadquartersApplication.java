package com.retail.headquarters;

import com.retail.headquarters.connection.TCPClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@SpringBootApplication
public class HeadquartersApplication {


	public HeadquartersApplication() throws IOException {
	}

	public static void main(String[] args) {
		SpringApplication.run(HeadquartersApplication.class, args);
	}



}

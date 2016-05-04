package com.veggie.src.java.app.prototype;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class Server {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/transaction", new TransactionMenu());
        server.createContext("/media", new MediaMenu());
        server.createContext("/account", new AccountMenu());
        server.createContext("/", new MainMenu());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started!");
    }

    public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static void sendToLogin(HttpExchange httpExchange) throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("<html><script>");
        response.append("window.location = \"/\"");
        response.append("</script></html>");
        writeResponse(httpExchange, response.toString());
    }
}

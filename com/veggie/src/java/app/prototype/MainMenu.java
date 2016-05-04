package com.veggie.src.java.app.prototype;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MainMenu implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().toString().substring(1);
        if (query.equals("favicon.ico")) return;
        if (query.length() == 0) {
            handleLogin(httpExchange);
        } else {
            int sessionId = Integer.parseInt(query);
            handleMainMenu(httpExchange, sessionId);
        }
    }

    public void handleMainMenu(HttpExchange httpExchange, int sessionId) throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("<html><body>");
        response.append("<h1>Main Menu</h1><br/>");
        response.append("<a href = \"/media/" + sessionId + "\">Media</a><br/>");
        response.append("<a href = \"/transaction/" + sessionId + "\">Transaction</a><br/>");
        response.append("<a href = \"/account/" + sessionId + "\">Account</a><br/>");
        response.append("<a href = \"/\">Log Out</a><br/>");
        response.append("</body></html>");
        Server.writeResponse(httpExchange, response.toString());
    }

    public void handleLogin(HttpExchange httpExchange) throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("<html><body>");
        response.append("<h1>Please Log In</h1><br/>");
        response.append("<a href = \"/1\">Enter</a><br/>");
        response.append("</body></html>");
        Server.writeResponse(httpExchange, response.toString());
    }
}

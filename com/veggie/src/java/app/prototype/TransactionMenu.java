package com.veggie.src.java.app.prototype;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TransactionMenu implements HttpHandler {

    private static final String HANDLE_PATH = "/transaction/";

    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().toString().substring(HANDLE_PATH.length());
        if (query.length() == 0) {
            Server.sendToLogin(httpExchange);
        } else {
            int sessionId = Integer.parseInt(query);
            handleMenu(httpExchange, sessionId);
        }
    }

    public void handleMenu(HttpExchange httpExchange, int sessionId) throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("<html><body>");
        response.append("<h1>Transactions</h1><br/>");
        response.append("<a href=\"/" + sessionId + "\">Back</a><br/>");
        response.append("</body></html>");
        Server.writeResponse(httpExchange, response.toString());
    }
}

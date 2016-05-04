package com.veggie.src.java.app.prototype;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.core.Account;

public class LoginMenu implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        Scanner queryScanner = new Scanner(httpExchange.getRequestBody());
        String query = queryScanner.nextLine();
        Map<String, String> formResponse = Server.queryToMap(query);
        List<String> data = new ArrayList<>();
        for(String key : formResponse.keySet()) {
            data.add(formResponse.get(key));
        }
        Account userAccount = AbstractDatabaseManagerFactory.getInstance()
            .createAccountDatabaseManager().matchUsername(data.get(0));
        if (userAccount != null && userAccount.passwordMatches(data.get(1))) {
            int session = Server.openSession(userAccount);
            StringBuilder response = new StringBuilder();
            response.append("<html><script>");
            response.append("window.location = \"/" + session +"\"");
            response.append("</script></html>");
            Server.writeResponse(httpExchange, response.toString());
        } else {
            Server.sendToLogin(httpExchange);
        }
    }
}

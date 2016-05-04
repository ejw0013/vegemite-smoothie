package com.veggie.src.java.app.prototype;

import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import com.veggie.src.java.controllers.account.*;
import com.veggie.src.java.controllers.Controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AccountMenu implements HttpHandler {
    private static final String HANDLE_PATH = "/account/";

    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().toString();
        if (query.length() == 0 || query.charAt(query.length() - 1) != '/') query += "/";
        query = query.substring(HANDLE_PATH.length());

        if (query.length() == 0) {
            Server.sendToLogin(httpExchange);
        } else {
            int slashLoc = query.indexOf("/");
            if (slashLoc < 0) slashLoc = query.length();
            int sessionId = Integer.parseInt(query.substring(0, slashLoc));
            String controller = query.substring(slashLoc + 1);
            if (controller.indexOf("/") > 0) controller = controller.substring(0, controller.indexOf("/"));
            handleMenu(httpExchange, sessionId, controller);
        }

    }

    public void handleMenu(HttpExchange httpExchange, int sessionId, String controller) throws IOException {

        Map<String, Controller> controllerMap = Server.getAccountBinding(sessionId).getControllers();
        Map<String, String> nameMap = Server.getAccountBinding(sessionId).getNames();

        if (controller.length() == 0) {
            StringBuilder response = new StringBuilder();
            response.append("<html><body>");
            response.append("<h1>Accounts</h1><br/>");
            String linkStart = "<a href=\"/account/" + sessionId + "/";
            String linkEnd = "\">";
            String lineEnd = "</a><br/>";
            for (String s : controllerMap.keySet()) {
                response.append(linkStart + s + linkEnd + nameMap.get(s) + lineEnd);
            }
            response.append("<a href=\"/" + sessionId + "\">Back</a><br/>");
            response.append("</body></html>");
            Server.writeResponse(httpExchange, response.toString());
        } else if (controllerMap.containsKey(controller)) {
            Controller c = controllerMap.get(controller);
            StringBuilder response = new StringBuilder();
            response.append(c.activate().getFieldNames().toString());
            Server.writeResponse(httpExchange, response.toString());
        } else {
            StringBuilder response = new StringBuilder();
            response.append("<html><body>");
            response.append("<h3>Invalid Controller Reference</h3><br/>");
            response.append("<a href=\"/" + sessionId + "\">Back</a><br/>");
            response.append("</body></html>");
            Server.writeResponse(httpExchange, response.toString());
        }
    }
}

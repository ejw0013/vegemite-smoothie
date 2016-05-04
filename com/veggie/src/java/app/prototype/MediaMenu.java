package com.veggie.src.java.app.prototype;

import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.controllers.media.*;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MediaMenu implements HttpHandler {

    private static final String HANDLE_PATH = "/media/";

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

        Map<String, Controller> controllerMap = new TreeMap<>();
        controllerMap.put("edititem", new EditItemController());
        controllerMap.put("removeitem", new RemoveItemController());
        controllerMap.put("additem", new AddItemController());

        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("additem", "Add Item");
        nameMap.put("edititem", "Edit Item");
        nameMap.put("removeitem", "Remove Item");

        if (controller.length() == 0) {
            StringBuilder response = new StringBuilder();
            response.append("<html><body>");
            response.append("<h1>Media</h1><br/>");
            String linkStart = "<a href=\"/media/" + sessionId + "/";
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

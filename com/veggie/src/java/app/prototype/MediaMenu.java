package com.veggie.src.java.app.prototype;

import java.io.IOException;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.PrototypeForm;
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
            String[] uriInfo = query.split("/");
            int sessionId = Integer.parseInt(uriInfo[0]);
            String controller = "";
            int stepNo = -1;
            if (uriInfo.length > 1) {
                controller = uriInfo[1];
            }
            if (uriInfo.length > 2) {
                stepNo = Integer.parseInt(uriInfo[2]);
            }
        //    System.err.println(sessionId + " |" + controller + "| " + stepNo);
            handleMenu(httpExchange, sessionId, controller, stepNo);
        }

    }

    public void handleMenu(HttpExchange httpExchange, int sessionId, String controller, int stepNo) throws IOException {

        Map<String, Controller> controllerMap = Server.getMediaBinding(sessionId).getControllers();
        Map<String, String> nameMap = Server.getMediaBinding(sessionId).getNames();


        if (controller.length() == 0) {
            StringBuilder response = new StringBuilder();
            response.append("<html><body>");
            response.append("<h1>Media</h1><br/>");
            String linkStart = "<a href=\"/media/" + sessionId + "/";
            String linkEnd = "/0\">";
            String lineEnd = "</a><br/>";
            for (String s : controllerMap.keySet()) {
                response.append(linkStart + s + linkEnd + nameMap.get(s) + lineEnd);
            }
            response.append("<a href=\"/" + sessionId + "\">Back</a><br/>");
            response.append("</body></html>");
            Server.writeResponse(httpExchange, response.toString());
        } else if (controllerMap.containsKey(controller)) {
            if (stepNo == 0) {
                String uri = httpExchange.getRequestURI().toString();
                Controller c = controllerMap.get(controller);
                StringBuilder response = new StringBuilder();
                response.append(c.activate().render(uri));
                Server.writeResponse(httpExchange, response.toString());
            } else if (stepNo == 1){
                System.err.println("STEP 1");
                Controller c = controllerMap.get(controller);
                Scanner queryScanner = new Scanner(httpExchange.getRequestBody());
                String query = queryScanner.nextLine();
                Map<String, String> formResponse = Server.queryToMap(query);
                List<String> fieldNames = new ArrayList<>(), fieldData = new ArrayList<>();
                for (String fieldName : formResponse.keySet()) {
                    String fieldEntry = formResponse.get(fieldName);
                    fieldNames.add(fieldName);
                    fieldData.add(fieldEntry);
                }
                Form f = new PrototypeForm(fieldNames, fieldData);
                System.err.println("LEAVE STEP 1");
                Server.writeResponse(httpExchange, "PENDING");
            } else {
                Server.writeResponse(httpExchange, "INVALID STEP NUMBER");
            }
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

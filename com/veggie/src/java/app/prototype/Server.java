package com.veggie.src.java.app.prototype;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.core.account.employee.LibrarianAccount;
import com.veggie.src.java.core.account.patron.FacultyAccount;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class Server {

    private static Map<Integer, Account> sessionUsers;
    private static Map<Integer, ControllerBinding> accountBindings;
    private static Map<Integer, ControllerBinding> mediaBindings;
    private static Map<Integer, ControllerBinding> transactionBindings;
    private static int sessionNumber;


    public static void main(String[] args) throws Exception {
        sessionNumber = 0;
        sessionUsers = new HashMap<>();
        accountBindings = new HashMap<>();
        mediaBindings = new HashMap<>();
        transactionBindings = new HashMap<>();

        Account adminAccount = new LibrarianAccount("admin", "(555) 555-555", 0, 12345, "password");
        AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager().add(adminAccount);

/*
        sessionUsers.put(1, adminAccount);
        int p = adminAccount.getPermissions();
        accountBindings.put(1, ControllerBinding.createAccountBinding(p));
        mediaBindings.put(1, ControllerBinding.createMediaBinding(p));
        transactionBindings.put(1, ControllerBinding.createTransactionBinding(p));
        sessionNumber++; */

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/transaction", new TransactionMenu());
        server.createContext("/media", new MediaMenu());
        server.createContext("/account", new AccountMenu());
        server.createContext("/login", new LoginMenu());
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

    public static ControllerBinding getAccountBinding(int sessionId) {
        return accountBindings.get(sessionId);
    }

    public static ControllerBinding getMediaBinding(int sessionId) {
        return mediaBindings.get(sessionId);
    }

    public static ControllerBinding getTransactionBinding(int sessionId) {
        return transactionBindings.get(sessionId);
    }

    public static Account getSessionAccount(int sessionId) {
        return sessionUsers.get(sessionId);
    }

    public static int getNextSessionNumber() {
        sessionNumber++;
        return sessionNumber;
    }

    public static int openSession(Account acct) {
        int p = acct.getPermissions();
        int sNum = getNextSessionNumber();
        sessionUsers.put(sNum, acct);
        accountBindings.put(sNum, ControllerBinding.createAccountBinding(p));
        mediaBindings.put(sNum, ControllerBinding.createMediaBinding(p));
        transactionBindings.put(sNum, ControllerBinding.createTransactionBinding(p));
        return sNum;
    }

    public static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new LinkedHashMap<>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0].replace('+', ' '), pair[1].replace('+', ' '));
            } else {
                result.put(pair[0].replace('+', ' '), "");
            }
        }
        return result;
    }
}

package com.veggie.src.java.app.prototype;

import java.util.*;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.controllers.account.*;
import com.veggie.src.java.controllers.media.*;
import com.veggie.src.java.controllers.transaction.*;
import com.veggie.src.java.core.Account;

public class ControllerBinding {
    private Map<String, Controller> controllerMap;
    private Map<String, String> nameMap;

    private ControllerBinding(Map<String, Controller> controllerMap, Map<String, String> nameMap) {
        this.controllerMap = controllerMap;
        this.nameMap = nameMap;
    }

    public Map<String, Controller> getControllers() {
        return controllerMap;
    }

    public Map<String, String> getNames() {
        return nameMap;
    }

    public static ControllerBinding createAccountBinding(int permissions) {
        Map<String, Controller> cMap = new TreeMap<>();
        Map<String, String> nMap = new HashMap<>();

        if (permissions == Account.LIBRARIAN) {
            cMap.put("addaccount", new AddAccountController());
            cMap.put("addfee", new AddFeeController());
            cMap.put("deleteaccount", new DeleteAccountController());
            cMap.put("editaccount", new EditAccountController());
            cMap.put("lookupuser", new LookUpUserController());
            cMap.put("payfee", new PayFeeController());
            cMap.put("report", new ReportController());
            cMap.put("searchuser", new SearchUserController());
            cMap.put("suspendaccount", new SuspendAccountController());

            nMap.put("addaccount", "Add Account");
            nMap.put("addfee", "Add Fee");
            nMap.put("deleteaccount", "Delete Account");
            nMap.put("editaccount", "Edit Account");
            nMap.put("lookupuser", "Look Up User");
            nMap.put("payfee", "Pay Fee");
            nMap.put("report", "Generate Report");
            nMap.put("searchuser", "Search Users");
            nMap.put("suspendaccount", "Suspend Account");
        } else if (permissions == Account.ASSISTANT) {
            cMap.put("report", new ReportController());
            nMap.put("report", "Generate Report");
        }
        return new ControllerBinding(cMap, nMap);
    }

    public static ControllerBinding createMediaBinding(int permissions) {
        Map<String, Controller> cMap = new TreeMap<>();
        Map<String, String> nMap = new HashMap<>();

        if (permissions == Account.LIBRARIAN) {
            cMap.put("edititem", new EditItemController());
            cMap.put("removeitem", new RemoveItemController());
            cMap.put("additem", new AddItemController());

            nMap.put("additem", "Add Item");
            nMap.put("edititem", "Edit Item");
            nMap.put("removeitem", "Remove Item");
        }
        return new ControllerBinding(cMap, nMap);
    }

    public static ControllerBinding createTransactionBinding(int permissions) {
        Map<String, Controller> cMap = new TreeMap<>();
        Map<String, String> nMap = new HashMap<>();

        cMap.put("addreservation", new AddReservationController());
        cMap.put("cancelreservation", new CancelReservationController());
        cMap.put("checkout", new CheckoutController());
        cMap.put("renew", new RenewController());
        cMap.put("request", new RequestItemController());

        nMap.put("addreservation", "Add Reservation");
        nMap.put("cancelreservation", "Cancel Reservation");
        nMap.put("checkout", "Checkout");
        nMap.put("renew", "Renew");
        nMap.put("request", "Request");

        if (permissions == Account.LIBRARIAN) {
            cMap.put("respond", new RespondToRequestController());
            nMap.put("respond", "Respond");
            cMap.put("viewrequest", new ViewRequestController());
            nMap.put("viewrequest", "View Requests");
        }

        if (permissions == Account.LIBRARIAN || permissions == Account.ASSISTANT) {
            cMap.put("return", new ReturnController());
            nMap.put("return", "Return");
        }
        return new ControllerBinding(cMap, nMap);
    }
}

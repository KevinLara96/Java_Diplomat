/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakarta.tutorial.reservation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ReservationBean implements Serializable {

    private static final long serialVersionUID = -7258677092121565610L;
    private String name = "";
    private String totalValue = "120.00";
    private String email = "";
    private String emailAgain = "";
    private String date = "";
    private String tickets = "1";
    private String price = "120";
    private Map<String, Object> ticketAttrs;
    private Map<String, Object> priceAttrs;

    public ReservationBean() {
        this.ticketAttrs = new HashMap<>();
        this.ticketAttrs.put("type", "number");
        this.ticketAttrs.put("min", "1");
        this.ticketAttrs.put("max", "4");
        this.ticketAttrs.put("required", "required");
        this.ticketAttrs.put("title",
                "Enter a number between 1 and 4 inclusive.");

        this.priceAttrs = new HashMap<>();
        this.priceAttrs.put("type", "number");
        this.priceAttrs.put("min", "80");
        this.priceAttrs.put("max", "120");
        this.priceAttrs.put("step", "20");
        this.priceAttrs.put("required", "required");
        this.priceAttrs.put("title", "Enter a price: 80, 100, 120 o 140.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAgain() {
        return emailAgain;
    }

    public void setEmailAgain(String emailAgain) {
        this.emailAgain = emailAgain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Map<String, Object> getTicketAttrs() {
        return ticketAttrs;
    }

    public void setTicketAttrs(Map<String, Object> ticketAttrs) {
        this.ticketAttrs = ticketAttrs;
    }

    public Map<String, Object> getPriceAttrs() {
        return priceAttrs;
    }

    public void setPriceAttrs(Map<String, Object> priceAttrs) {
        this.priceAttrs = priceAttrs;
    }

    public void calculateTotal(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        int ticketsNum = 1;
        int ticketPrice = 0;
        int total;

        if (tickets.trim().length() > 0) {
            ticketsNum = Integer.parseInt(tickets);
        }
        if (price.trim().length() > 0) {
            ticketPrice = Integer.parseInt(price);
        }
        total = (ticketsNum * ticketPrice);
        totalValue = String.valueOf(total) + ".00";
    }

    public void clear(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        name = "";
        email = "";
        emailAgain = "";
        date = "";
        price = "120.00";
        totalValue = "120.00";
        tickets = "1";
    }
}

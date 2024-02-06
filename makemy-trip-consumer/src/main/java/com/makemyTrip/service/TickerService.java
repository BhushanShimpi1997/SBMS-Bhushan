package com.makemyTrip.service;

import com.makemyTrip.request.Passenger;
import com.makemyTrip.response.Ticket;

import java.util.List;

public interface TickerService {

    public Ticket bookTicket(Passenger passenger);

    public List<Ticket> getTickets();

    public Ticket getTicket(Integer ticketNum);
}

package com.irctc.service;

import com.irctc.entity.Passenger;
import com.irctc.entity.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket bookTicket(Passenger passenger);

    public List<Ticket> getTickets();

    public Ticket getTicket(Integer tickerNum);

}

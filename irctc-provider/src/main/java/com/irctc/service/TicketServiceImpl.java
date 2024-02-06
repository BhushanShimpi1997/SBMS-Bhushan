package com.irctc.service;

import com.irctc.entity.Passenger;
import com.irctc.entity.Ticket;
import com.irctc.repository.TicketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository repository;

    @Override
    public Ticket bookTicket(Passenger passenger) {

        Ticket ticket = new Ticket();

        ticket.setTicketStatus("CONFIRM");

        ticket.setPrice(1500.00);

        BeanUtils.copyProperties(passenger,ticket);

        final Ticket saveTicket = repository.save(ticket);

        return saveTicket;
    }

    @Override
    public List<Ticket> getTickets() {

        final List<Ticket> tickets = repository.findAll();

        return tickets;
    }

    @Override
    public Ticket getTicket(Integer ticketNum) {

        final Optional<Ticket> byId = repository.findById(ticketNum);

        if(byId.isPresent()){
           return byId.get();
        }
        return null;
    }
}

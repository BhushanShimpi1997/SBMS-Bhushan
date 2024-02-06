package com.irctc.controller;

import com.irctc.entity.Passenger;
import com.irctc.entity.Ticket;
import com.irctc.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService service;

    @PostMapping(value = "/ticket",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){

        final Ticket ticket = service.bookTicket(passenger);

        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping(value = "/tickets", produces = "application/json")
    public ResponseEntity<List<Ticket>> getAllTickets(){

        final List<Ticket> tickets = service.getTickets();

        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping(value = "/ticket/{ticketNum}", produces = "application/json")
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNum") Integer ticketNum){

        final Ticket ticket = service.getTicket(ticketNum);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}

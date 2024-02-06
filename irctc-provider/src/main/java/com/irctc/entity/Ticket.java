package com.irctc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketNum;

    private String name;

    private String phno;

    private String gender;
    @Column(name = "from_add")
    private String from;
    @Column(name = "to_add")
    private String to;

    private LocalDate doj;

    private Double price;

    private String ticketStatus;

    private Integer trainNum;
}

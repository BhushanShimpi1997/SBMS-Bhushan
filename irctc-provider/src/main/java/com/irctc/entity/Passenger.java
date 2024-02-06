package com.irctc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class Passenger {

    private String name;
    private String phno;
    private String gender;
    private String from;
    private String to;
    private LocalDate doj;
    private Integer trainNum;
}

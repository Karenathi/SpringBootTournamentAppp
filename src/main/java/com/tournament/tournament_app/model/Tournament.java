package com.tournament.tournament_app.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Tournament {
    private int id_tournament;
    private  String tournament_name;
    private LocalDate date_of_start;
    private LocalDate date_of_end;
    private Float duration_hours;
}

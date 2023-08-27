package com.tournament.tournament_app.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Match {
    private int id_match;
    private LocalDate match_date;
    private LocalTime match_time;
    private String score;
    private String results;
}

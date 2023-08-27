package com.tournament.tournament_app.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Player {
    private int id;
    private String pseudo;
    private LocalDate birthdate;
    private String gender;
    private String ranking;
}

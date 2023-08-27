package com.tournament.tournament_app.controller;

import com.tournament.tournament_app.model.Player;
import com.tournament.tournament_app.model.Tournament;
import com.tournament.tournament_app.service.PlayerService;
import com.tournament.tournament_app.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() throws SQLException {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestBody Player playerToUpdate) {
        try {
            playerToUpdate.setId(id);
            playerService.updatePlayer(playerToUpdate);
            return ResponseEntity.ok("Player updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating player.");
        }
    }

    @PostMapping
    public ResponseEntity<String> insertPlayer(@RequestBody Player newPlayer) {
        try {
            playerService.insertPlayer(newPlayer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting player.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.ok("Player deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting player.");
        }
    }
}

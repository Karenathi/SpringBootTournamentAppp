package com.tournament.tournament_app.repository.interfaces;

import com.tournament.tournament_app.model.Player;
import com.tournament.tournament_app.model.Tournament;

import java.sql.SQLException;
import java.util.List;

public interface PlayerInterface {
    List<Player> getAllPlayers() throws SQLException;
    void updatePlayer( Player player) throws  SQLException;
    void insertPlayer(Player player) throws SQLException;
    void deletePlayer(int id) throws SQLException;
}

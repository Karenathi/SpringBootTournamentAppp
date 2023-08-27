package com.tournament.tournament_app.service;

import com.tournament.tournament_app.model.Player;
import com.tournament.tournament_app.repository.interfaces.PlayerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerInterface playerDao;

    @Autowired
    public PlayerService(PlayerInterface playerDao) {
        this.playerDao = playerDao;
    }

    public List<Player> getAllPlayers() throws SQLException {
        return playerDao.getAllPlayers();
    }

    public void updatePlayer(Player player) throws SQLException {
        playerDao.updatePlayer(player);
    }

    public void insertPlayer(Player player) throws SQLException {
        playerDao.insertPlayer(player);
    }

    public void deletePlayer(int playerId) throws SQLException {
        playerDao.deletePlayer(playerId);
    }

}
package com.tournament.tournament_app.repository.dao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {
    private String username = "postgres";
    private String password = "motherlode";

    @Bean
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost/tournamentapp",
                username,
                password
        );
    }
}

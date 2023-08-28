SpringBootTournamentApp

This project enables you to efficiently manage tournaments using a RESTful API. You can easily create, update, retrieve, and delete tournaments, matches, and players.

Features
Tournaments: Create, update, retrieve, and delete tournaments.
Matches: Manage matches by associating them with relevant tournaments and players.
Players: Add, update, retrieve, and delete player information.
Technologies Used
Spring Boot
Spring Web
PSQL Driver
Maven
Lombok
Usage
The API provides the following endpoints for each entity:

Tournaments
GET /tournaments: Retrieve the list of all tournaments.
GET /tournaments/{id}: Retrieve details of a specific tournament.
POST /tournaments: Create a new tournament.
PUT /tournaments/{id}: Update details of an existing tournament.
DELETE /tournaments/{id}: Delete a tournament.

Matches
GET /matches: Retrieve the list of all matches.
GET /matches/{id}: Retrieve details of a specific match.
POST /matches: Create a new match and associate it with a tournament and players.
PUT /matches/{id}: Update details of an existing match.
DELETE /matches/{id}: Delete a match.

Players
GET /players: Retrieve the list of all players.
GET /players/{id}: Retrieve details of a specific player.
POST /players: Add a new player to the database.
PUT /players/{id}: Update details of an existing player.
DELETE /players/{id}: Delete a player.

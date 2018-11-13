package no.experis.ballc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PlayerInfo {
    @JsonProperty("person_id")
    int personId;
    @JsonProperty("player_id")
    int playerId;
    @JsonProperty("team_id")
    int teamId;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("date_of_birth")
    LocalDate birthDate;
    @JsonProperty("normal_position")
    String normalPosition;
    @JsonProperty("number")
    int number;

    public PlayerInfo() {
    }

    public PlayerInfo(Person person, Player player) {
        this.personId = person.getPerson_id();
        this.playerId = player.getPlayer_id();
        this.teamId = player.getTeam();
        this.firstName = person.getFirst_name();
        this.lastName = person.getLast_name();
        this.birthDate = person.getDate_of_birth();
        this.normalPosition = player.getNormal_position();
        this.number = player.getNumber();
    }
/*
    public PlayerInfo(Person person, Player player, Team team) {
        this.personId = person.getPerson_id();
        this.playerId = player.getPlayer_id();
        this.teamId = team.getTeam_id();
        this.firstName = person.getFirst_name();
        this.lastName = person.getLast_name();
        this.birthDate = person.getDate_of_birth();
        this.normalPosition = player.getNormal_position();
        this.number = player.getNumber();
    }*/

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNormalPosition() {
        return normalPosition;
    }

    public void setNormalPosition(String normalPosition) {
        this.normalPosition = normalPosition;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
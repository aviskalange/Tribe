package com.taskmaster.service;

import com.taskmaster.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Team createTeam(Team team);
    Optional<Team> getTeamById(Long id);
    List<Team> getAllTeams();
    Team updateTeam(Long id, Team teamDetails);
    void deleteTeam(Long id);
}
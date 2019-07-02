package com.launchacademy.teamrosterwithspring.services;

import static com.launchacademy.teamrosterwithspring.models.League.getLeague;

import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TeamBasedService implements TeamService {

  private List<Team> teams;

  public TeamBasedService() {
    teams = getLeague().getTeams();
  }

  @Override
  public List<Team> getList() {
    return teams;
  }

  @Override
  public Team getSpecificTeam(String teamIndex) {
    return teams.get(Integer.parseInt(teamIndex));
  }

  @Override
  public List<String> getPositions() {
    return Arrays.asList("Skip", "Third", "Second", "Lead", "Alternate");
  }

  @Override
  public Map<Player, Team> getSpecificPosition(String position) {

    Map<Player, Team> players = new LinkedHashMap<>();
    List<Team> teams = this.getList();

    for (Team team : teams) {
      List<Player> playersInTeam = team.getPlayers();
      for (Player player : playersInTeam) {
        if (player.getPosition().equals(position)) {
          players.put(player, team);
        }
      }
    }

    return players;
  }
}

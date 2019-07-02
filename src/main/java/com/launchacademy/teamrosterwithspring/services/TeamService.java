package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.List;
import java.util.Map;

public interface TeamService {
  List<Team> getList();
  Team getSpecificTeam(String teamIndex);
  List<String> getPositions();
  Map<Player, Team> getSpecificPosition(String position);
}

package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
@RequestMapping
public class TeamsController {

  @Autowired
  private TeamService teamService;

  @GetMapping
  public String getTeamNames(Model model) {
    model.addAttribute("teams", teamService.getList());
    return "teams/index";
  }

  @GetMapping("/teams/{teamIndex}")
  public String getSpecificTeam(@PathVariable String teamIndex, Model model) {
    if (Integer.parseInt(teamIndex) >= teamService.getList().size()) {
      throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    } else {
      model.addAttribute("team", teamService.getSpecificTeam(teamIndex));
      return "teams/show";
    }
  }

  @GetMapping("/positions")
  public String getPositions(Model model) {
    model.addAttribute("positions", teamService.getPositions());
    return "positions/index";
  }

  @GetMapping("/positions/{position}")
  public String getSpecificPosition(@PathVariable String position, Model model) {
    model.addAttribute("position", teamService.getSpecificPosition(position));
    model.addAttribute("positionName", position);
    return "positions/show";
  }
}

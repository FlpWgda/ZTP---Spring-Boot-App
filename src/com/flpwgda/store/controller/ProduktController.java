package com.flpwgda.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flpwgda.store.dao.PlayerDAO;
import com.flpwgda.store.dao.TeamDAO;
import com.flpwgda.store.entity.Player;
import com.flpwgda.store.entity.Team;

@Controller
@RequestMapping("/ztp0")
public class ProduktController {
	
	@Autowired
	private PlayerDAO playerDAO;
	
	@Autowired
	private TeamDAO teamDAO;
	
	
	@RequestMapping("/acc")
	public String listTeams(Model theModel) {
		
		List<Team> teams = teamDAO.getTeams();
		List<Team> teamsFull = new ArrayList<Team>();
		for(Team t:teams) {
			if(!t.equals(null)) {
				teamsFull.add(t);
			}
		}
			
		theModel.addAttribute("teams",teamsFull);
		
		return "index";
		
	}
	
	@RequestMapping("/showFormForAddTeam")
	public String showFormForAddTeam(Model theModel) {
		
		Team team = new Team();
		
		theModel.addAttribute("team",team);
		
		return "team-form";
	}
	@RequestMapping("/showFormForUpdateTeam")
	public String showFormForUpdateTeam(@RequestParam("teamId") int theId, Model theModel) {
		
		Team team = teamDAO.getTeam(theId);
		
		theModel.addAttribute("team",team);
		
		return "team-form";
	}
	
	@GetMapping("/deleteTeam")
	public String deleteTeam(@RequestParam("teamId") int theId) {
		
		teamDAO.removeTeam(theId);
		
		playerDAO.removePlayers(theId);
		return "redirect:/";
	}
	@RequestMapping("/saveTeam")
	public String saveTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
				
		teamDAO.addTeam(team);
			return "redirect:/";				
	}
	
	@RequestMapping("/listPlayers")
	public String listPlayers(@RequestParam("teamId") int theId, Model theModel) {
		
		List<Player> players = playerDAO.getPlayers(theId);
		String teamName = teamDAO.getTeam(theId).getNazwa();
			
		theModel.addAttribute("players",players);
		theModel.addAttribute("Team", teamName);
		
		return "list-players";		
	}
	
	@RequestMapping("/showFormForAddPlayer")
	public String showFormForAddPlayer(Model theModel) {
		
		Player player = new Player();
		
		theModel.addAttribute("player", player);
		
		return "player-form";
	}
	@RequestMapping("/showFormForUpdatePlayer")
	public String showFormForUpdatePlayer(@RequestParam("playerId") int theId, Model theModel) {
		
		Player player = playerDAO.getPlayer(theId);
		
		theModel.addAttribute("player", player);
		
		return "player-form";
	}
	
	@GetMapping("/deletePlayer")
	public String deletePlayer(@RequestParam("playerId") int theId) {
		
		playerDAO.removePlayer(theId);
		return "redirect:/listPlayers";
	}
	@RequestMapping("/savePlayer")
	public String savePlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
				
		playerDAO.addPlayer(player);
			return "redirect:/listPlayers";				
	}	
}

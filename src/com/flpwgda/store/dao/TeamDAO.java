package com.flpwgda.store.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flpwgda.store.entity.Team;

@Repository
public class TeamDAO {
	
	File file;
	List<Team> teams;
	
	@Autowired
	public TeamDAO() {
		file = new File("Users/hp/Desktop/F/6 semestr/ZTP/teams.txt");
		teams = getTeams();
		
	}
	
	
	private SessionFactory sessionFactory;
	
	public void removeTeam(int teamNumber) {
		teams.set(teamNumber,null);
	}
	public void addTeam(Team team) {
		teams.add(team);
		team.setNumer(teams.size()-1);
	}
	public void updateTeam(int index,String nazwa) {
		teams.set(index, new Team(nazwa,index));
	}
	public Team getTeam(int index) {
		return teams.get(index);
	}
	public List<Team> getTeams(){
		Scanner odczyt;
		try {
			odczyt = new Scanner(file);
			do {
				String[] temp = odczyt.nextLine().split(",");
				teams.set(Integer.parseInt(temp[1]), new Team(temp[0],Integer.parseInt(temp[1])));
			}
			while(odczyt.hasNextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams;		
	}
	public void saveTeams() throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (Team t:teams) {
			bw.write(t.toString());
			bw.newLine();
		}
	 
		bw.close();
	}

}

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

import com.flpwgda.store.entity.Player;
import com.flpwgda.store.entity.Team;

@Repository
public class PlayerDAO {
	
	File file;
	List<Player> players;
	
	@Autowired
	public PlayerDAO() {
		file = new File("Users/hp/Desktop/F/6 semestr/ZTP/players.txt");
		players = getPlayers();
		
	}
	public void removePlayer(int index) {
		players.remove(index);
	}
	public void removePlayers(int team) {
		for(Player p:players) {
			if(p.getDruzyna() == team) {
				players.remove(p);
			}
		}
	}
	public void addPlayer(Player player) {
		players.add(player);
	}
	public void updatePlayer(int index, String nazwa, int druzyna) {
		players.set(index, new Player(nazwa,druzyna));
	}
	public Player getPlayer(int id) {
		return players.get(id);
	}
	public List<Player> getPlayers(int teamId){
		List<Player> playersTeam = new ArrayList<Player>();
		for(Player p:players) {
			if(p.getDruzyna() == teamId) {
				playersTeam.add(p);
			}
		}
		return playersTeam;
	}
	public List<Player> getPlayers(){
		Scanner odczyt;
		try {
			odczyt = new Scanner(file);
			do {
				String[] temp = odczyt.nextLine().split(",");
				players.set(Integer.parseInt(temp[1]), new Player(temp[0],Integer.parseInt(temp[1])));
			}
			while(odczyt.hasNextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}
	public void savePlayers() throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (Player p:players) {
			bw.write(p.toString());
			bw.newLine();
		}
	 
		bw.close();
	}

}

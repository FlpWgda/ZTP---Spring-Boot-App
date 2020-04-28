package com.flpwgda.store.entity;

public class Player {
	
	private String nazwa;
	private int druzyna;
	
	public Player() {
		
	}
	public Player(String nazwa, int druzyna) {
		this.nazwa = nazwa;
		this.druzyna = druzyna;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getDruzyna() {
		return druzyna;
	}
	public void setDruzyna(int druzyna) {
		this.druzyna = druzyna;
	}
	@Override
	public String toString() {
		return nazwa+","+druzyna;
	}

}

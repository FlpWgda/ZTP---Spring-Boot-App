package com.flpwgda.store.entity;

public class Team {
	
	private String nazwa;
	private int numer;
	
	public Team() {
		
	}
	public Team(String nazwa,int numer) {
		this.nazwa = nazwa;
		this.numer = numer;
		
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getNumer() {
		return numer;
	}
	public void setNumer(int numer) {
		this.numer = numer;
	}
	@Override
	public String toString() {
		return nazwa+","+numer;
	}

}

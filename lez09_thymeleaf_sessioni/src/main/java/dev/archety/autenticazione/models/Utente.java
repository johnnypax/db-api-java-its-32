package dev.archety.autenticazione.models;

public class Utente {

	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Utente [user=" + user + ", pass=" + pass + "]";
	}
	
	
	
}

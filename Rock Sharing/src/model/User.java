package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class User {
	
	private ArrayList<Integer> userVotesOn = new ArrayList<Integer>();
	private String username;
	private String password;
	private int userlevel;
	private String email;
	private Date timestamp;
	
	public ArrayList<Integer> getUserVotesOn(){
		return userVotesOn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTimestamp() {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		return date;
	}
	
	public User(String username, String password, int userlevel, String email) {
		super();
		this.username = username;
		this.password = password;
		this.userlevel = userlevel;
		this.email = email;
	}
	public User(String username, String password, int userlevel, String email, Date timestamp) {
		super();
		this.username = username;
		this.password = password;
		this.userlevel = userlevel;
		this.email = email;
		this.timestamp = timestamp;
	}
	public User() {
		
	}
	
	
}

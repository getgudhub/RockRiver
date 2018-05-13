package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import model.User;

public class UsersDAO {

	User user = new User();
	
	public static String query = "INSERT INTO `users`"
			+ "(`username`, `password`, `userlevel`, `email`,`timestamp`, `votesOn`)"
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	
	public void addUser(User user){
		try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		pst.setInt(3, user.getUserlevel());
		pst.setString(4, user.getEmail());
		pst.setDate(5, (Date) user.getTimestamp());
		pst.setInt(6, 0);
		pst.execute();
		pst.close();
		System.out.println("Successfully added the user");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Failed to add the user");
		}
	}
	
	public User getUser(String username, String password) {
		String sql="Select * From users Where (username = ? AND password = ?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement pavad = con.prepareStatement(sql);
			pavad.setString(1, username);
			pavad.setString(2, password);
			ResultSet rs = pavad.executeQuery();
				if(rs.next()) {
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setUserlevel(rs.getInt("userlevel"));
					user.setEmail(rs.getString("email"));
					String str;
					int i = 0;
					str = rs.getString("votesOn");
							while(i<str.length()) {
								if(str.charAt(i)==' ') {
									i++;
									continue;
								}else {
									user.getUserVotesOn().add(Character.getNumericValue(str.charAt(i)));
									i++;
								}	
							}
					}
		}catch (Exception e){
			e.printStackTrace();
		}
		return user;
	}
	public void updateUserVotes(String username, ArrayList<Integer> getUserVotesOn){
		query="Update users Set VotesOn = ?  Where username = ?";
		String str = "";
		Iterator<Integer> it = getUserVotesOn.iterator();
		try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
		PreparedStatement pst = con.prepareStatement(query);
		while(it.hasNext()) {
			str+=it.next().toString()+" ";
		}
		pst.setString(1, str);
		pst.setString(2, username);
		pst.execute();
		pst.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void updateUserPassword(String username, String password){
		query="Update users Set password = ?  Where username = ?";
		try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, password);
		pst.setString(2, username);
		pst.execute();
		pst.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void updateUserEmail(String username, String email){
		query="Update users Set email = ?  Where username = ?";
		try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, email);
		pst.setString(2, username);
		pst.execute();
		pst.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}   

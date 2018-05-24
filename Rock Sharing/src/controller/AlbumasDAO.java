package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Albumas;
import model.User;
import view.DalinimosiAnketa;

public class AlbumasDAO {

	public static String query = "INSERT INTO `albumai`"
			+ "(`username`, `title`, `artist`, `songs`, `genre`,"
			+ " `year`, `rating`,`votes`,`lastUpdated`, `downloadSite`, `ratingPoints`)"
			+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public void addAlbum(Albumas album){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, album.getUsername());
			pst.setString(2, album.getTitle());
			pst.setString(3, album.getArtist());
			pst.setInt(4, album.getSongs());
			pst.setString(5, album.getGenre());
			pst.setInt(6, album.getYear());
			pst.setInt(7, album.getRating());
			pst.setInt(8, album.getVotes());
			pst.setDate(9, album.getLastUpdated());
			pst.setString(10, album.getDownloadSite());	
			pst.setInt(11, album.getRatingPoints());
			pst.execute();
			pst.close();
			con.close();
			System.out.println("Successfully added an Album");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Failed to add");
		}
	}
	
	public void deleteAlbum(int id, User user){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement pst = con.prepareStatement("DELETE FROM albumai WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();
			pst.close();
			con.close();
			System.out.println("Successfuly deleted an Album");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed to delete");
		}
	}
	
	public void updateAlbum(Albumas album, User user){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement pst = con.prepareStatement("UPDATE albumai SET title = ?, artist = ?," +
					"songs = ?, genre = ?, year = ?, lastUpdated = ?, downloadSite = ? WHERE id=" + album.getId() );
			pst.setString(1, album.getTitle());
			pst.setString(2, album.getArtist());
			pst.setInt(3, album.getSongs());
			pst.setString(4, album.getGenre());
			pst.setInt(5, album.getYear());
			pst.setDate(6, album.getLastUpdated());
			pst.setString(7, album.getDownloadSite());
			pst.execute();
			pst.close();
			con.close();
			System.out.println("Update successful");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed to update");
		}
	}
	public void rateAlbum(Albumas album, User user){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement pst = con.prepareStatement("UPDATE albumai SET rating = ?, votes = ?, ratingPoints = ? WHERE id=" +album.getId() );
			pst.setInt(1,  album.getRating());
			pst.setInt(2,  album.getVotes());
			pst.setInt(3,  album.getRatingPoints());
			pst.execute();
			pst.close();
			System.out.println("Update successful");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed to update");
		}
	}
	
	public void showAlbums(ObservableList<Albumas> data, User user) {
		String query ;
			query = "SELECT * FROM albumai";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement add = con.prepareStatement(query);
			ResultSet rs = add.executeQuery();
			while(rs.next()) {
				data.add(new Albumas(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("title"),
					rs.getString("artist"),
					rs.getInt("songs"),
					rs.getString("genre"),
					rs.getInt("year"),
					rs.getInt("rating"),
					rs.getInt("votes"),
					rs.getDate("lastUpdated"),
					rs.getString("downloadSite"),
					rs.getInt("ratingPoints")
				));
			}
			add.close();
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void showMyAlbums(ObservableList<Albumas> data, User user) {
		String query ;
			query = "SELECT * FROM albumai WHERE username LIKE '"+ user.getUsername() +"'";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duombaze", "root", "");
			PreparedStatement add = con.prepareStatement(query);
			ResultSet rs = add.executeQuery();
			while(rs.next()) {
				data.add(new Albumas(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("title"),
					rs.getString("artist"),
					rs.getInt("songs"),
					rs.getString("genre"),
					rs.getInt("year"),
					rs.getInt("rating"),
					rs.getInt("votes"),
					rs.getDate("lastUpdated"),
					rs.getString("downloadSite"),
					rs.getInt("ratingPoints")
				));
			}
			add.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

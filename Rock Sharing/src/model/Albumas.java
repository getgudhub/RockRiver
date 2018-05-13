package model;

import java.sql.Date;

public class Albumas {
	
	private int id;
	private String username;
	private String title;
	private String artist;
	private int songs;
	private String genre;
	private int year;
	private int rating;
	private int votes;
	private Date lastUpdated;
	private String downloadSite;
	private int ratingPoints;
		
	
	public Albumas( String username, String title, String artist, int songs, String genre, int year, int rating, int votes, Date lastUpdated, String downloadSite, int ratingPoints) {
		super();
		//this.id = id;
		this.username = username;
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.genre = genre;
		this.year = year;
		this.rating = rating;
		this.votes = votes;
		this.lastUpdated = lastUpdated;
		this.downloadSite = downloadSite;
		this.ratingPoints = ratingPoints;
	}
	public Albumas(int id, String username, String title, String artist, int songs, String genre, int year, int rating, int votes, Date lastUpdated, String downloadSite, int ratingPoints) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.genre = genre;
		this.year = year;
		this.rating = rating;
		this.votes = votes;
		this.lastUpdated = lastUpdated;
		this.downloadSite = downloadSite;
		this.ratingPoints = ratingPoints;
	}
	public Albumas(int id, String username, String title, String artist, int songs, String genre, int year, Date lastUpdated, String downloadSite) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.genre = genre;
		this.year = year;
		this.lastUpdated = lastUpdated;
		this.downloadSite = downloadSite;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getSongs() {
		return songs;
	}
	public void setSongs(int songs) {
		this.songs = songs;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDownloadSite() {
		return downloadSite;
	}
	public void setDownloadSite(String downloadSite) {
		this.downloadSite = downloadSite;
	}
	public int getRatingPoints() {
		return ratingPoints;
	}
	public void setratingpoints(int ratingPoints) {
		this.ratingPoints = ratingPoints;
	}
	
}

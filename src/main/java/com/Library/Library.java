package com.Library;

public class Library {


	private int song_id;
	private String song_name;
	private String artist_name;
	private double price;
	private String images;
	
	
	public Library () {
		
	}
	
	public Library(int song_id, String song_name, String artist_name, double price2, String image) {
		super();
		this.song_id = song_id;
		this.song_name = song_name;
		this.artist_name = artist_name;
		this.price = price2;
		this.images = image;
	}

	public int getsong_id() {
		return song_id;
	}

	public void setsong_id(int id) {
		this.song_id = id;
	}

	public String getsong_name() {
		return song_name;
	}

	public void setsong_name(String name) {
		this.song_name = name;
	}

	public String getartist_name() {
		return artist_name;
	}

	public void setartist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public double getprice() {
		return price;
	}

	public void setpric(double price) {
		this.price = price;
	}

	public String getimages() {
		return images;
	}

	public void setimages(String image) {
		this.images = image;
	}

	@Override
	public String toString() {
		return "Library [id=" + song_id + ", name=" + song_name + ", artist_name=" + artist_name + ", price=" + price + ", image="
				+ images + "]";
	}

	
	 
}

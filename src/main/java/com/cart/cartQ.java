package com.cart;

public class cartQ extends Cart{
	

	private String quality; 
	
	
	
	
public cartQ(int song_id, String song_name, double price,String quality) {
		super(song_id, song_name, price);
		// TODO Auto-generated constructor stub
		this.quality=quality;
	}




public String getquality() {
	return quality;
}




public void setquality(String quality) {
	this.quality = quality;
}
}

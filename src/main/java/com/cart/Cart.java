package com.cart;

public class Cart {
    private int song_id;  
    private String song_name;
    private double price;
   

     

    public Cart(int song_id, String song_name, double price) {
        this.song_id = song_id;
        this.song_name = song_name;
        this.price = price;
       
          
    }

    
    public int getsong_id() {
        return song_id;
    }

    public String getsong_name() {
        return song_name;
    }


    public double getprice() {
        return price;
    }


	@Override
	public String toString() {
		return "Cart [song_id=" + song_id + ", song_name=" + song_name + ", price=" + price + "]";
	}







	
	
	
    
}

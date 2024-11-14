package till_system;

import java.util.ArrayList;

public class drink {
	
	private String name;
	private float price;
	private String size;
	private ArrayList<add_ons> add_ons = new ArrayList<add_ons>();

	
	public drink(String name, float price, String size) {
		this.name = name;
		this.price = price;
		this.size = size;
	}
	

	public String getName() {
		return name;
	}


	public float getPrice() {
		return price;
	}


	public String getSize() {
		return size;
	}


	public ArrayList<add_ons> getAdd_ons() {
		return add_ons;
	}

	
}

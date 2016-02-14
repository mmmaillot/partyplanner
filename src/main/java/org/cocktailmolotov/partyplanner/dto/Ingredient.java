package org.cocktailmolotov.partyplanner.dto;

public class Ingredient {
	
	private String id;
	private int qty;
	
	public Ingredient() {
		// no attributes needed
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}

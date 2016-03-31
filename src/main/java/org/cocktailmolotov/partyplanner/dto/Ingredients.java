package org.cocktailmolotov.partyplanner.dto;

import java.util.HashMap;
import java.util.List;

public class Ingredients {
	
	private HashMap<String, Double> ingredients;

	public Ingredients() {
		// no attribute needed
	}
	
	public HashMap<String, Double> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<String, Double> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}

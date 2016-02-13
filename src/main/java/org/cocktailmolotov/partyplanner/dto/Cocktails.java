package org.cocktailmolotov.partyplanner.dto;

import java.util.List;

public class Cocktails {
	
	private List<Cocktail> cocktails;

	public Cocktails() {
		// no attributes needed
	}
	
	public List<Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(List<Cocktail> cocktails) {
		this.cocktails = cocktails;
	}
	

}

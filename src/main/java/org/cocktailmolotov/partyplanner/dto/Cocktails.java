package org.cocktailmolotov.partyplanner.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Cocktails {

	private HashMap<String,Cocktail> cocktails;

	public Cocktails() {
		// no attributes needed
		cocktails = new HashMap<>();
	}

	public HashMap<String,Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(HashMap<String,Cocktail> cocktails) {
		this.cocktails = cocktails;
	}

	@Override
	public String toString() {
		String result = new String();
		for(Entry<String,Cocktail> cocktail : cocktails.entrySet()){
			result += cocktail.toString() + "\n";
		}
		return result;
	}

}

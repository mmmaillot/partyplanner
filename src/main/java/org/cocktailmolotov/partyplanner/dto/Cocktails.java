package org.cocktailmolotov.partyplanner.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Cocktails {

	private HashMap<String,HashMap<String,Integer>> cocktails;

	public Cocktails() {
		// no attributes needed
	}

	public HashMap<String,HashMap<String,Integer>> getCocktails() {
		return cocktails;
	}

	public void setCocktails(HashMap<String,HashMap<String,Integer>> cocktails) {
		this.cocktails = cocktails;
	}

	@Override
	public String toString() {
		String result = new String();
		for(Entry<String,HashMap<String,Integer>> cocktail : cocktails.entrySet()){
			result += cocktail.toString() + "\n";
		}
		return result;
	}

}

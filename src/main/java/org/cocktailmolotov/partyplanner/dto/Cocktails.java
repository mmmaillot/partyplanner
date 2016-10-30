package org.cocktailmolotov.partyplanner.dto;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Cocktails {

	private TreeMap<String,Cocktail> cocktails;

	public Cocktails() {
		// no attributes needed
		cocktails = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	}

	public TreeMap<String,Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(Map<String,Cocktail> cocktails) {
		for(Map.Entry<String,Cocktail> e : cocktails.entrySet()){
			this.cocktails.put(e.getKey(),e.getValue());
		}
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

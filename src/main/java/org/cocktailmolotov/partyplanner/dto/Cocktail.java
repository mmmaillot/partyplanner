package org.cocktailmolotov.partyplanner.dto;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by maxime on 11/02/16.
 */
public class Cocktail extends HashMap<String, Integer> {
    private String id;

    public Cocktail(){
        // no parameters needed
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
    	String result = new String();
    	result += getId() + "\n";
    	for(Entry<String, Integer> dose : entrySet()){
    		result += dose.getKey() + " : " + dose.getValue() + "\n";
    	}
    	return result;
    }
}

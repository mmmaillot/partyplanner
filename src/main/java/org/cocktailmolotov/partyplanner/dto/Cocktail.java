package org.cocktailmolotov.partyplanner.dto;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by maxime on 11/02/16.
 */
public class Cocktail {
    private String id;
    private HashMap<String,Integer> doses;

    public Cocktail(){
        // no parameters needed
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Integer> getDoses() {
        return doses;
    }

    public void setDoses(HashMap<String, Integer> doses) {
        this.doses = doses;
    }
    
    @Override
    public String toString() {
    	String result = new String();
    	result += getId() + "\n";
    	for(Entry<String, Integer> dose : getDoses().entrySet()){
    		result += dose.getKey() + " : " + dose.getValue() + "\n";
    	}
    	return result;
    }
}

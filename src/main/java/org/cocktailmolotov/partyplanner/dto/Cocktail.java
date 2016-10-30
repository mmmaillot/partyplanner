package org.cocktailmolotov.partyplanner.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by maxime on 11/02/16.
 */
public class Cocktail {
    private HashMap<String, Integer> recipe;

    public Cocktail(){
        // no parameters needed
    }

    public HashMap<String, Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(HashMap<String, Integer> recipe) {
        this.recipe = recipe;
    }


    @Override
    public String toString() {
    	String result = new String();
    	for(Entry<String, Integer> dose : recipe.entrySet()){
    		result += dose.getKey() + " : " + dose.getValue() + "\n";
    	}
    	return result;
    }
}

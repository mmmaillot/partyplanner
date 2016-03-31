package org.cocktailmolotov.partyplanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.cocktailmolotov.partyplanner.dto.Cocktails;
import org.cocktailmolotov.partyplanner.dto.Ingredients;
import org.cocktailmolotov.partyplanner.io.CocktailLoader;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Created by maxime on 06/02/16.
 */
public class Main {

	public static void main(String args[]) throws IOException, URISyntaxException, ParseException {

		File file = CocktailLoader.getLoader().getCocktailsFile();
		ObjectMapper om = new ObjectMapper();
		Cocktails cocktails = om.readValue(file, Cocktails.class);
		HashMap<String, Double> ingredientsMap = new HashMap<>();
		for(HashMap<String, Double> cocktail : cocktails.getCocktails().values()){
			for(String ingred : cocktail.keySet()){
				System.out.println(ingred);
			}
		}
		Ingredients ingredients = new Ingredients();
		ingredients.setIngredients(ingredientsMap);
		file = CocktailLoader.getLoader().getIngredientsFile();
		om.writerWithDefaultPrettyPrinter().writeValue(file, ingredients);
	}
}
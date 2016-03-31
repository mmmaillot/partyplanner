package org.cocktailmolotov.partyplanner.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.cocktailmolotov.partyplanner.dto.Cocktails;
import org.cocktailmolotov.partyplanner.dto.Ingredients;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by maxime on 11/02/16.
 */
public class CocktailLoader {

	static Loader LOADER = new Loader();
	public static Loader getLoader(){
		return LOADER;
	} 


	public static class Loader {
		private Loader() {
			// Nothing
		}

		final String COCKTAILS_URL = "/home/maxime/code/partyplanner/src/main/resources/cocktails.json";
		final String INGREDIENTS_URL = "/home/maxime/code/partyplanner/src/main/resources/ingredients.json";

		public File getCocktailsFile() throws IOException {
			return new File(COCKTAILS_URL);
		}

		public File getIngredientsFile() throws IOException {
			return new File(INGREDIENTS_URL);
		}
		
		public Cocktails loadCocktails() throws IOException{
			File file = getCocktailsFile();
			ObjectMapper om = new ObjectMapper();
			Cocktails cocktails = om.readValue(file, Cocktails.class);
			return cocktails;
		}
		
		public Ingredients loadIngredients() throws IOException{
			File file = getIngredientsFile();
			ObjectMapper om = new ObjectMapper();
			return om.readValue(file, Ingredients.class);
		}
	}
}
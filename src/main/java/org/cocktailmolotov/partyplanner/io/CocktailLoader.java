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

	final private static Loader LOADER = new Loader();

	public static Loader getLoader(){
		return LOADER;
	}


	public static class Loader {
		final private ObjectMapper om = new ObjectMapper();
		private Loader() {
			// Nothing
		}


		final InputStream COCKTAILS_STREAM = getClass().getClassLoader().getResourceAsStream("cocktails.json");
		final InputStream INGREDIENTS_STREAM = getClass().getClassLoader().getResourceAsStream("ingredients.json");

		
		public Cocktails loadCocktails() throws IOException{
			Cocktails cocktails = om.readValue(COCKTAILS_STREAM, Cocktails.class);
			return cocktails;
		}
		
		public Ingredients loadIngredients() throws IOException{
			return om.readValue(INGREDIENTS_STREAM, Ingredients.class);
		}
	}
}
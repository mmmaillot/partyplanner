package org.cocktailmolotov.partyplanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.cocktailmolotov.partyplanner.dto.Cocktail;
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

	public static void main(String args[]) throws IOException, URISyntaxException, ParseException, org.apache.commons.cli.ParseException {

		// create Options object
		Options options = new Options();
		options.addOption("n", true, "The number of person attending the party");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse( options, args);


		int quantite = 10;
		if(cmd.hasOption("n")){
			quantite = Integer.parseInt(cmd.getOptionValue("n"));
		}
		HashMap<String, Integer> groceries = new HashMap<>();

		Cocktails cocktails = CocktailLoader.getLoader().loadCocktails();
		Ingredients ingredients = CocktailLoader.getLoader().loadIngredients();
		System.out.println(cocktails.getCocktails().get("Mai Tai"));
		System.out.println(ingredients.getIngredients().get("gin"));
		HashMap<String, Double> maiTai = cocktails.getCocktails().get("Mai Tai");
		for(String ingredient : maiTai.keySet()){
			System.out.println(ingredient + " : " + roundUp(quantite * maiTai.get(ingredient) / ingredients.getIngredients().get(ingredient)));
		}
	}
	
	public static int roundUp(double qty){
		return (int) Math.round(Math.ceil(qty));
	}
}
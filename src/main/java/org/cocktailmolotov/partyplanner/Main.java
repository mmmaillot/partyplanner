package org.cocktailmolotov.partyplanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.cli.*;
import org.cocktailmolotov.partyplanner.dto.Cocktail;
import org.cocktailmolotov.partyplanner.dto.Cocktails;
import org.cocktailmolotov.partyplanner.dto.Ingredients;
import org.cocktailmolotov.partyplanner.function.QtyCalculator;
import org.cocktailmolotov.partyplanner.io.CocktailLoader;
import org.cocktailmolotov.partyplanner.utils.CocktailsOptionsBuilder;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Created by maxime on 06/02/16.
 */
public class Main {

	public static void main(String args[]) throws IOException, URISyntaxException, ParseException {

		Options options = CocktailsOptionsBuilder.getOptions();
		HelpFormatter formatter = new HelpFormatter();

		Cocktails cocktails = CocktailLoader.getLoader().loadCocktails();
		Ingredients ingredients = CocktailLoader.getLoader().loadIngredients();

		CommandLineParser parser = new DefaultParser();
		try{
			CommandLine cmd = parser.parse( options, args);

			if(cmd.hasOption("p")){
				cocktails.getCocktails().keySet().stream().forEach(p -> System.out.println(p));
			}

			int qty = Integer.parseInt(cmd.getOptionValue("n"));
			String[] cocktailsFromCLI = cmd.getOptionValues("cocktail-list");
			HashMap<String, Integer> groceries = QtyCalculator.computeQtys(cocktailsFromCLI,qty, cocktails, ingredients);
			System.out.println(groceries);
		} catch (org.apache.commons.cli.ParseException e){
			formatter.printHelp("partyplanner", options);
		}
	}
}
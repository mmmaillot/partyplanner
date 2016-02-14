package org.cocktailmolotov.partyplanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.cocktailmolotov.partyplanner.dto.Cocktail;
import org.cocktailmolotov.partyplanner.dto.Cocktails;
import org.cocktailmolotov.partyplanner.io.CocktailLoader;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by maxime on 06/02/16.
 */
public class Main {

    public static void main(String args[]) throws IOException, URISyntaxException, ParseException {
    	
    	File file = CocktailLoader.getLoader().getCocktailsFile();

    	ObjectMapper om = new ObjectMapper();
        Cocktail mizuwari = createMizuwariCocktail();
        Cocktail daiquiri =  createDaiquiriCocktail();
        HashMap<String,HashMap<String,Integer>> cocktailMap = new HashMap<>();
        cocktailMap.put(mizuwari.getId(),mizuwari.getDoses());
        cocktailMap.put(daiquiri.getId(),daiquiri.getDoses());
        Cocktails cocktails = new Cocktails();
        cocktails.setCocktails(cocktailMap);
//        String cocktailFile = "/home/maxime/Documents/cocktails.json";
        om.writerWithDefaultPrettyPrinter().writeValue(file, cocktails);
        System.out.println("done");
        Cocktails cocktail = om.readValue(file, Cocktails.class);
        System.out.println(cocktail);
    }

    private static Cocktail createMizuwariCocktail(){
        Cocktail cocktail = new Cocktail();
        cocktail.setId("Mizuwari");
        HashMap<String,Integer> doses = new HashMap<>();
        doses.put("water", 50);
        doses.put("whisky",50);
        cocktail.setDoses(doses);
        return cocktail;
    }
    
    private static Cocktail createDaiquiriCocktail(){
        Cocktail cocktail = new Cocktail();
        cocktail.setId("Daiquiri");
        HashMap<String,Integer> doses = new HashMap<>();
        doses.put("rhum", 60);
        doses.put("lime juice",30);
        doses.put("simple syrup",15);
        cocktail.setDoses(doses);
        return cocktail;
    }
}
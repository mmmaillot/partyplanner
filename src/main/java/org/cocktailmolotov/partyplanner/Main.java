package org.cocktailmolotov.partyplanner;

import org.cocktailmolotov.partyplanner.io.IngredientsLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;


/**
 * Created by maxime on 06/02/16.
 */
public class Main {


    public static void main(String args[]) throws IOException, URISyntaxException, ParseException {
        JSONParser parser = new JSONParser();

        System.out.println("chocolat");

        IngredientsLoader il = new IngredientsLoader();
        InputStreamReader ingredientsFile = new InputStreamReader(il.loadIngredients());
        Object obj = parser.parse(ingredientsFile);
        JSONObject ingredientObject = (JSONObject) obj;
        JSONArray ingredients = (JSONArray) ingredientObject.get("ingredients");

        for(Object ingredient : ingredients){
            JSONObject jsonIngred = (JSONObject)ingredient;
            System.out.println(jsonIngred.get("ingredient"));
        }
        System.console().readLine();
        System.out.println("Yeah, Me too ...");
    }
}
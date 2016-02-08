package org.cocktailmolotov.partyplanner;

import org.cocktailmolotov.partyplanner.io.IngredientsLoader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
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
        InputStreamReader ingredients = new InputStreamReader(il.loadIngredients());
        Object obj = parser.parse(ingredients);
        JSONObject jsonObject = (JSONObject) obj;
        String ingredient = (String) jsonObject.get("ingredient");
        String qty = (String) jsonObject.get("qty");

        System.out.println(ingredient + " : " + qty);
        String blob = System.console().readLine();
        System.out.println("Yeah, Me too ...");
    }
}
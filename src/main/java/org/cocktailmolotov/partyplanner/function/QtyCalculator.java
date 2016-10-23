package org.cocktailmolotov.partyplanner.function;

import org.cocktailmolotov.partyplanner.dto.Cocktails;
import org.cocktailmolotov.partyplanner.dto.Ingredients;
import org.cocktailmolotov.partyplanner.io.CocktailLoader;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by maxime on 23/10/16.
 */
public class QtyCalculator {

    public static HashMap<String, Integer> computeQtys(String[] cocktailsNames, int n, Cocktails cocktails, Ingredients ingredients){

        Set<String> currentIngredients = Arrays.stream(cocktailsNames)
                .flatMap(cocktail -> cocktails.getCocktails().get(cocktail).keySet().stream())
                .collect(Collectors.toSet());

        HashMap<String, Double> totalQtyByIngredients = new HashMap<>();
        currentIngredients.stream().forEach(ingred -> totalQtyByIngredients.put(ingred, 0d));

        for(String cocktail : cocktailsNames){
            for(Map.Entry<String, Double> entry : cocktails.getCocktails().get(cocktail).entrySet()){
                totalQtyByIngredients.compute(entry.getKey(), (k,v) -> v + entry.getValue());
            }
        }

        HashMap<String, Integer> totalBottles = new HashMap<>();
        for(Map.Entry<String,Double> entry : totalQtyByIngredients.entrySet()){
            totalBottles.put(entry.getKey(), roundUp(n * entry.getValue() / ingredients.getIngredients().get(entry.getKey())));
        }

        return totalBottles;
    }

    public static int roundUp(double qty){
        return (int) Math.round(Math.ceil(qty));
    }
}

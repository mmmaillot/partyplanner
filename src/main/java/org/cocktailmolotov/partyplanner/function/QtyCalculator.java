package org.cocktailmolotov.partyplanner.function;

import org.cocktailmolotov.partyplanner.dto.Cocktails;
import org.cocktailmolotov.partyplanner.dto.Ingredients;
import org.cocktailmolotov.partyplanner.dto.Query;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by maxime on 23/10/16.
 */
public class QtyCalculator {

    public static HashMap<String, Integer> computeQtys(Query query, Cocktails cocktails, Ingredients ingredients){

        Set<String> currentIngredients = query.getCocktailList()
                .stream()
                .flatMap(cocktail -> cocktails.getCocktails().get(cocktail).getRecipe().keySet().stream())
                .collect(Collectors.toSet());

        HashMap<String, Double> totalQtyByIngredients = new HashMap<>();
        currentIngredients.stream().forEach(ingred -> totalQtyByIngredients.put(ingred, 0d));

        for(String cocktail : query.getCocktailList()){
            for(Map.Entry<String, Integer> entry : cocktails.getCocktails().get(cocktail).getRecipe().entrySet()){
                totalQtyByIngredients.compute(entry.getKey(), (k,v) -> v + entry.getValue());
            }
        }

        HashMap<String, Integer> totalBottles = new HashMap<>();
        for(Map.Entry<String,Double> entry : totalQtyByIngredients.entrySet()){
            totalBottles.put(entry.getKey(), roundUp(query.getnGuests() * entry.getValue() / ingredients.getIngredients().get(entry.getKey())));
        }

        return totalBottles;
    }

    public static int roundUp(double qty){
        return (int) Math.round(Math.ceil(qty));
    }
}
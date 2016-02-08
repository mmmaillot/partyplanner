package org.cocktailmolotov.partyplanner.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by maxime on 08/02/16.
 */
public class IngredientsLoader {

    public IngredientsLoader(){}

    public InputStream loadIngredients() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL ingredients = classLoader.getResource("ingredients.json");
        return ingredients.openStream();
    }
}

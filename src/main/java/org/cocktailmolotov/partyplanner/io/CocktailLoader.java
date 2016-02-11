package org.cocktailmolotov.partyplanner.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by maxime on 11/02/16.
 */
public class CocktailLoader implements JSONLoader {

    final String COCKTAILS_URL = "cocktails.json";
    @Override
    public InputStream load() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL cocktails = classLoader.getResource(COCKTAILS_URL);
        return cocktails.openStream();   }
}
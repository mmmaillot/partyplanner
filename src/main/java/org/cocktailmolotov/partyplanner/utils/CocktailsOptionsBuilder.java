package org.cocktailmolotov.partyplanner.utils;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Created by maxime on 23/10/16.
 */
public class CocktailsOptionsBuilder {

    public static Options getOptions(){
        // create Options object
        Options options = new Options();

        options.addOption("n", true, "The number of person attending the party");

        Option cocktailList = Option.builder()
                .required()
                .argName("cl")
                .desc("The list of cocktails")
                .longOpt("cocktail-list")
                .numberOfArgs(Option.UNLIMITED_VALUES)
                .build();
        options.addOption(cocktailList);

        return options;
    }
}

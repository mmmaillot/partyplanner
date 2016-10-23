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

        Option numberParticipants = new Option("n",true,"The number of person attending the party");
        numberParticipants.setRequired(true);
        options.addOption(numberParticipants);

        options.addOption("p", false, "Print the cocktails list");

        Option cocktailList = Option.builder()
                .required()
                .desc("The list of cocktails, separated by spaces")
                .longOpt("cocktail-list")
                .numberOfArgs(Option.UNLIMITED_VALUES)
                .build();
        options.addOption(cocktailList);

        return options;
    }
}

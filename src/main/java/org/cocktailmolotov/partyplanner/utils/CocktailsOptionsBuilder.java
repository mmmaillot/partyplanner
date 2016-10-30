package org.cocktailmolotov.partyplanner.utils;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Created by maxime on 23/10/16.
 */
public class CocktailsOptionsBuilder {

    private static final Options OPTIONS = createOptions();

    public static Options getOptions(){
        return OPTIONS;
    }

    private static Options createOptions(){
        // create Options object
        Options options = new Options();

        Option numberParticipants = new Option(CocktailConsts.N_GUESTS,true,"The number of person attending the party");
        numberParticipants.setRequired(true);
        options.addOption(numberParticipants);

        options.addOption(CocktailConsts.PRINT, false, "Print the cocktails list");

        Option cocktailList = Option.builder()
                .required()
                .desc("The list of cocktails, separated by spaces")
                .longOpt(CocktailConsts.COCKTAILS_LIST)
                .numberOfArgs(Option.UNLIMITED_VALUES)
                .build();
        options.addOption(cocktailList);

        return options;
    }
}

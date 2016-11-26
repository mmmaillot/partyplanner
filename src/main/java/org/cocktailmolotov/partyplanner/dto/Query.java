package org.cocktailmolotov.partyplanner.dto;

import java.util.List;

/**
 * Created by maxime on 26/11/16.
 */
public class Query {
    int nPersons;
    List<Cocktail> cocktails;

    private Query(int nPersons, List<Cocktail> cocktails){
        this.nPersons = nPersons;
        this.cocktails = cocktails;
    }

    public class Builder{

        private int nPersons;
        private List<Cocktail> cocktails;

        public Builder setnPersons(int nPersons) {
            this.nPersons = nPersons;
            return this;
        }

        public Builder setCocktails(List<Cocktail> cocktails) {
            this.cocktails = cocktails;
            return this;
        }

        public Query build() {
            return new Query(nPersons, cocktails);
        }
    }
}



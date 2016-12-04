package org.cocktailmolotov.partyplanner.dto;

import java.util.List;

/**
 * Created by H9A on 04-Dec-16.
 */
public class Query {
    private final int nGuests;
    private final List<String> cocktailList;

    private Query(int nGuests, List<String> cocktailList) {
        this.nGuests = nGuests;
        this.cocktailList = cocktailList;
    }

    public int getnGuests() {
        return nGuests;
    }

    public List<String> getCocktailList() {
        return cocktailList;
    }

    public static class Builder{

        private int nGuests;
        private List<String> cocktailList;

        public Builder setnGuests(int nGuests) {
            this.nGuests = nGuests;
            return this;
        }

        public Builder setCocktailList(List<String> cocktailList) {
            this.cocktailList = cocktailList;
            return this;
        }

        public Query createQuery() {
            return new Query(nGuests, cocktailList);
        }
    }
}

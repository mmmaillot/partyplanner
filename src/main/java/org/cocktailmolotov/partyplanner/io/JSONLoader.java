package org.cocktailmolotov.partyplanner.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by maxime on 11/02/16.
 */
public interface JSONLoader {
    public File load() throws IOException;
}

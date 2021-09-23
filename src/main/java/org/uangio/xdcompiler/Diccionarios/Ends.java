package org.uangio.xdcompiler.Diccionarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ends extends Dic {
    private static Ends nodo;

    public static Ends getNodo() {
        if (nodo == null) {
            nodo = new Ends();
        }
        return nodo;
    }

    private final String[] regex;
    private final Pattern[] p;


    public Ends() {
        regex = getEnds();
        p = new Pattern[regex.length];
        init(p, regex);
    }

    public boolean isThis(String txt) {
        return isThis(p, txt);
    }
}

package org.uangio.xdcompiler.Diccionarios;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Variables extends Dic {

    private static Variables nodo;

    public static Variables getNodo() {
        if (nodo == null) {
            nodo = new Variables();
        }
        return nodo;
    }

    private final String[] regex;
    private final Pattern[] p;
    private Matcher m;


    private Variables() {
        this.regex = getVariables();
        p = new Pattern[regex.length];
        init(p, regex);
    }


    public boolean isThis(String txt) {
        return isThis(p, txt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variables)) return false;
        Variables variables = (Variables) o;
        return Arrays.equals(regex, variables.regex) && Arrays.equals(p, variables.p) && m.equals(variables.m);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m);
        result = 31 * result + Arrays.hashCode(regex);
        result = 31 * result + Arrays.hashCode(p);
        return result;
    }
}

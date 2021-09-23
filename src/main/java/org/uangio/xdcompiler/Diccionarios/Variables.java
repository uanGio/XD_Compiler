package org.uangio.xdcompiler.Diccionarios;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Variables {

    private static Variables nodo;

    public static Variables getNodo() {
        if (nodo == null) {
            nodo = new Variables();
        }
        return nodo;
    }

    private final String[] regex = {""};
    private final Pattern[] p = new Pattern[regex.length];
    private Matcher m;


    private Variables() {
        for (int i = 0; i < regex.length; i++) {
            p[i] = Pattern.compile(regex[i]);
        }
    }

    public boolean instancia1(String txt) {
        this.m = p[0].matcher(txt);
        return m.find();
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

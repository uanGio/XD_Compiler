package org.uangio.xdcompiler.Diccionarios;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constantes extends Dic {

    private static Constantes nodo;

    public static Constantes getNodo() {
        if (nodo == null) nodo = new Constantes();
        return nodo;

    }

    private final String[] regex;
    private final Pattern[] p;
    private Matcher m;


    private Constantes() {
        regex = getConstantes();
        p = new Pattern[regex.length];
        init();
    }

    private void init() {
        for (int i = 0; i < regex.length; i++) {
            p[i] = Pattern.compile(regex[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Constantes)) return false;
        Constantes that = (Constantes) o;
        return Arrays.equals(regex, that.regex) && Arrays.equals(p, that.p) && m.equals(that.m);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m);
        result = 31 * result + Arrays.hashCode(regex);
        result = 31 * result + Arrays.hashCode(p);
        return result;
    }
}

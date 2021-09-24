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
        /*   p[i] = Pattern.compile(regex[i]);
        }*/
        Pattern pattern = Pattern.compile(regex[0]);
        m = pattern.matcher("VAR = \"hola123\"");
    }
    public void find(int id){
        m.find(id);
        System.out.println(m.group(1));
    }
    public boolean struct_const(String type, String line){
        Pattern p = null;
        switch (type){
            case "int":
                return p.matches(get_constante_regexp_with_id(1), line);
            case "str":
                return p.matches(get_constante_regexp_with_id(0), "GIO=\"hola\"");
            default:
                return false;
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

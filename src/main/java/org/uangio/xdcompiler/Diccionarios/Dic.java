package org.uangio.xdcompiler.Diccionarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Dic {

    private final String[] Variables = {};
    private final String[] Constantes = {};
    private final String[] Ends = {"__", "}"};

    public String[] getVariables() {
        return Variables;
    }

    public String[] getConstantes() {
        return Constantes;
    }

    public String[] getEnds() {
        return Ends;
    }

    protected void init(Pattern[] p, String[] regex) {
        for (int i = 0; i < regex.length; i++) {
            p[i] = Pattern.compile(regex[i]);
        }
    }

    protected boolean isThis(Pattern[] p,String txt) {
        Matcher m;
        for (Pattern pattern : p) {
            m = pattern.matcher(txt);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }
}

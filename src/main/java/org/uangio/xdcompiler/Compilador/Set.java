package org.uangio.xdcompiler.Compilador;

public class Set {

    private String[] code;

    public Set(String... code) {
        this.code = code;
    }

    protected String[] getCode() {
        return code;
    }
}

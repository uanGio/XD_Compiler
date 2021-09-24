package org.uangio.xdcompiler.Compilador;

public class Get {

    private String code;

    public Get() {

    }

    public void setCode(String code) {
        this.code = code;
        new Evaluador(code);
    }

    public String getCode() {
        return code;
    }

}

package org.uangio.xdcompiler.Compilador;

import org.uangio.xdcompiler.Diccionarios.Constantes;
import org.uangio.xdcompiler.Diccionarios.Ends;
import org.uangio.xdcompiler.Diccionarios.Variables;

abstract class Objeto {
    //
    private int aperturas, cierres;
    //
    private Constantes c = Constantes.getNodo();
    private Variables v = Variables.getNodo();
    private Ends e = Ends.getNodo();

    protected boolean is(String txt) {
        if (!c.isThis(txt)) {
            return true;
        }
        if (v.isThis(txt)) {
            return true;
        }
        if (e.isThis(txt)) {
            cierres++;
            return true;
        }
        return false;
    }


    public String TypeOf(Object c) {
        if (c instanceof Integer) {
            return "int";
        }
        if (c instanceof Float || c instanceof Double) {
            return "float";
        }
        if (c instanceof Character) {
            return "char";
        }
        if (c instanceof String) {
            return "string";
        }
        return "null";
    }

    public int getAperturas() {
        return aperturas;
    }

    public int getCierres() {
        return cierres;
    }

    public String TypeOf(String txt){
        return type(txt);
    }

    private String type(String txt) {
        try {
            Integer x = Integer.parseInt(txt);
        } catch (NumberFormatException e) {

            return type2(txt);
        }
        return "int";
    }

    private String type2(String txt) {
        try {
            Double x = Double.parseDouble(txt);
        } catch (NumberFormatException e) {
            return type3(txt);
        }
        return "float";
    }

    private String type3(String txt) {
        switch (txt) {
            case "True":
                return "bool";
            case "False":
                return "bool";
            case "true":
                return "bool";
            case "false":
                return "bool";
        }
        return type4(txt);
    }

    private String type4(String txt) {
        if (txt.isEmpty() || txt.length() > 1) {
            return Type5(txt);
        }
        return "Char";
    }

    private String Type5(String txt) {
        if (txt.isEmpty()) {
            return "null";
        }
        return "string";
    }
}

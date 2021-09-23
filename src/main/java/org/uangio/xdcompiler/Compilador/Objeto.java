package org.uangio.xdcompiler.Compilador;

import org.uangio.xdcompiler.Diccionarios.Constantes;
import org.uangio.xdcompiler.Diccionarios.Ends;
import org.uangio.xdcompiler.Diccionarios.Variables;

abstract class Objeto {
    //
    private int aperturas, cierres;
    //
    Constantes c = Constantes.getNodo();
    Variables v = Variables.getNodo();
    Ends e = Ends.getNodo();

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

    public int getAperturas() {
        return aperturas;
    }

    public int getCierres() {
        return cierres;
    }
}

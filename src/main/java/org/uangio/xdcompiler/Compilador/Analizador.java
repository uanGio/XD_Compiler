package org.uangio.xdcompiler.Compilador;

import org.uangio.xdcompiler.Diccionarios.Constantes;
import org.uangio.xdcompiler.Diccionarios.Variables;

class Analizador extends Objeto implements Obj {

    private boolean Evaluacion, Accionador;
    private String[] Entrada;
    private String[] Salida;


    public Analizador(String[] Entrada) {
        this.Entrada = Entrada;
        this.Salida = new String[Entrada.length];
    }

    @Override
    public boolean Evaluacion() {

        return true;
    }

    @Override
    public boolean Accionador() {
        this.Evaluacion = Evaluacion();
        if (!Evaluacion) {
            return false;
        }
        for (int i = 0; i < Entrada.length; i++) {
            if (!Cadena(Entrada[i])) {
                return false;
            }
        }
        if (getAperturas() != getCierres()) {
            return false
        }
        return true;
    }

    private boolean Cadena(String line) {
        return is(line);
    }


    @Override
    public void Resultados() {
        this.Accionador = Accionador();
        if (Evaluacion && Accionador) {
            this.Salida = Entrada;
        }
    }

    public String[] getSalida() {
        return Salida;
    }
}

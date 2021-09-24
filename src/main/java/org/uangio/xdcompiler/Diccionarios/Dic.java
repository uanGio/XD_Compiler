package org.uangio.xdcompiler.Diccionarios;

abstract class Dic {

    //NAME = "PEPITO" || EDAD = 54 || ALTURA = 1.75 || LETRA = 'C'
    private final String[] constantes = {"[A-Z]=\"[a-zA-Z]{2,}\"", "[A-Z]{1,}[=]\\d+", "[A-Z] = \\d+"};

    public String[] getConstantes() {
        return constantes;
    }
    public String get_constante_regexp_with_id(int id){
        return constantes[id];
    }
}

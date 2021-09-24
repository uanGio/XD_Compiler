package org.uangio.xdcompiler.Compilador;

import java.util.HashMap;

public class Objects {
    private HashMap<String, Object> constantes = new HashMap<>();

    public void set_const(String type, Object value){
        constantes.put(type, value);
    }
    public Object get_const(String id){
        return constantes.get(id);
    }

}

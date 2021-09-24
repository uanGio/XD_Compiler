package org.uangio.xdcompiler.Compilador;
import org.uangio.xdcompiler.Diccionarios.*;

import java.util.*;

//Evaluador: Revisa la sintaxis del XD_Lenguaje.
public class Evaluador{
    private HashMap<String, Object> intruccions;

    Constantes constantes = Constantes.getNodo();

    public Evaluador(String line){
        line = line.replaceAll(" ", "");
        check_line(line);
    }
    public boolean check_line(String instruction){
        char[] ins = instruction.toCharArray();
        for (int i = 0; i < ins.length; i++){
            if(ins[i] == ':'){
                if(ins[i+1] == '=') {
                    System.out.println("->"+constantes.struct_const("str", instruction));
                    if(constantes.struct_const("str", instruction)){
                        System.out.println("CONSTANTE!");
                    }
                }else
                    syntax_error("Se esperaba '='");
            }
            else if(ins[i] == '='){
                if(constantes.struct_const("int", instruction)){
                    System.out.println("CONSTANTE de tipo entero!");
                }else{
                    syntax_error("¡Error al asignar la constante!");
                }
            }
            else if(ins[i] == '('){
                String[] struct = instruction.split("=");
            }
        }
        return true;
    }
    public void auto_completed(String type){

    }
    public void syntax_error(String message){
        System.out.println("-> " + message);
    }
}

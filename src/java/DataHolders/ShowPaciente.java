/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHolders;

import java.io.Serializable;

/**
 *
 * @author Punkid PC
 */
public class ShowPaciente implements Serializable{
    public String curp;
    public String nombre;
    public String apellidoP;
    public String apellidoM;

    public ShowPaciente(String curp, String nombre, String apellidoP, String apellidoM) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }
    
    
}

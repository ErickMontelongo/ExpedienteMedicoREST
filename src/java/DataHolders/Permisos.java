/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHolders;

/**
 *
 * @author Punkid PC
 */
public class Permisos {
    
    private boolean historial;
    private boolean medicamentos;
    private boolean sintomas;
    private boolean estudios;

    public Permisos(boolean historial, boolean medicamentos, boolean sintomas, boolean estudios) {
        this.historial = historial;
        this.medicamentos = medicamentos;
        this.sintomas = sintomas;
        this.estudios = estudios;
    }

    public boolean isHistorial() {
        return historial;
    }

    public boolean isMedicamentos() {
        return medicamentos;
    }

    public boolean isSintomas() {
        return sintomas;
    }

    public boolean isEstudios() {
        return estudios;
    }

    public void setHistorial(boolean historial) {
        this.historial = historial;
    }

    public void setMedicamentos(boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setSintomas(boolean sintomas) {
        this.sintomas = sintomas;
    }

    public void setEstudios(boolean estudios) {
        this.estudios = estudios;
    }
    
    
}

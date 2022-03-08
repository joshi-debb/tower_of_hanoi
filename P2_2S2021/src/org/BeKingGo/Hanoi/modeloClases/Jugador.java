package org.BeKingGo.Hanoi.modeloClases;

import java.io.Serializable;

public class Jugador implements Serializable {

    private String Nombre;
    private int RecordTiempo;
    private int CantMov;


    public Jugador() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getRecordTiempo() {
        return RecordTiempo;
    }

    public void setRecordTiempo(int recordTiempo) {
        RecordTiempo = recordTiempo;
    }

    public int getCantMov() {
        return CantMov;
    }

    public void setCantMov(int cantMov) {
        CantMov = cantMov;
    }
}

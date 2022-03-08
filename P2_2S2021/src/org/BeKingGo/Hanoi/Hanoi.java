package org.BeKingGo.Hanoi;

import org.BeKingGo.Hanoi.modelo.ModMenu;
import org.BeKingGo.Hanoi.modeloClases.Jugador;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Hanoi {

    //FUENTES GENERALES A USAR EN LA PRACTICA
    public static Font FuenteGeneralT1 = new Font("Showcard Gothic", Font.BOLD, 14);
    public static Font FuenteGeneralT2 = new Font("Showcard Gothic", Font.BOLD, 25);
    public static Font FuenteGeneralT3 = new Font("Showcard Gothic", 0, 14);
    public static Font FuenteGeneralT4 = new Font("Showcard Gothic", 0, 14);


    //OBJETO DE LA CLASE PRINCIPAL JUGADOR
    public static Jugador[] Records = new Jugador[5];
    public static int contadorJugadores = 0;

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    File validarContador = new File("ContadorJugadores.bin");
                    File validarRecords = new File("Records.bin");

                    if (validarContador.exists() && validarRecords.exists()) {

                        Hanoi.contadorJugadores = (int) Hanoi.desSerializacion("contadorJugadores.bin");
                        Hanoi.Records = (Jugador[]) Hanoi.desSerializacion("Records.bin");

                        JOptionPane.showMessageDialog(null, "Bienvenido a Torres de Hanoi - FIUSAC");
                        new ModMenu();

                    } else {

                        JOptionPane.showMessageDialog(null, "Bienvenido a Torres de Hanoi - FIUSAC");
                        new ModMenu();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        //CICLO QUE RECORRE LA CANTIDAD DE FILAS Y CREA LOS OBJETOS JUGADORES
        for (int i = 0; i < 5; i++) {
            Records[i] = new Jugador();
        }
    }



    //------------------SERIALIZACION---------------------------------

    public static void serializacion(String path, Object object) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object desSerializacion(String path) {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            Object data = objectInputStream.readObject();
            objectInputStream.close();

            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //----------------------------------------------------------------


}

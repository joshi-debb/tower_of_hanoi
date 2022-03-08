package org.BeKingGo.Hanoi.modeloClases;

import org.BeKingGo.Hanoi.modelo.ModMenu;
import org.BeKingGo.Hanoi.modelo.ModPlay;

import javax.swing.*;
import java.io.IOException;

public class CuentaRegresiva extends Thread{

    @Override
    public void run(){
            try {
                while ( ModPlay.contTiempoPartida != 0){
                    sleep(1000);
                    ModPlay.contTiempoPartida--;
                    ModPlay.lblt2.setText(String.valueOf(ModPlay.contTiempoPartida));

                    //VERIFICA SI EL JUGADOR SE HA QUEDADO SIN TIEMPO
                    if (ModPlay.contTiempoPartida == 0){

                        ModPlay.moduloDeJuego.setVisible(false);

                        JOptionPane.showMessageDialog(null,"Te has quedado sin tiempo, Has Perdido ! \n " +
                                "Intenta configurar una mayor cantidad de tiempo! :) ");

                        ModPlay.contTiempoPartida = 120;
                        new ModMenu();
                        ModPlay.contReversa.stop();
                        Potenciadores.hilo.stop();

                    }
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
    }
}

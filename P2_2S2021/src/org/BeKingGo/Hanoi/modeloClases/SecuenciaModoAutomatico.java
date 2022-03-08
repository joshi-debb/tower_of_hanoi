package org.BeKingGo.Hanoi.modeloClases;

import org.BeKingGo.Hanoi.modelo.ModAutomatic;
import org.BeKingGo.Hanoi.modelo.ModPlay;

import java.io.IOException;

public class SecuenciaModoAutomatico extends Thread{

    public static int contador;
    public static int minMovimientos;


    @Override
    public void run(){

        contador = 0;
        minMovimientos = (int) (Math.pow(2,ModPlay.CantidadDiscos) - 1);

        try {
            while (contador != minMovimientos){
                //ALGORITMO RECURVISO
                TorresHanoi(ModPlay.CantidadDiscos, 1, 2, 3);
            }
            ModAutomatic.txtArea1.append("       Juego terminado !");
            ModAutomatic.TextoAutomatico.stop();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    //----------ALGORITMO DE RECURSIVIDAD PARA TORRES DE HANOI----------

    public void TorresHanoi(int Discos, int TorreA, int TorreB, int TorreC) throws IOException, InterruptedException {

        //CASO BASE
        if   (Discos == 1) {

            ModAutomatic.txtArea1.append("       Mover Disco #"+ Discos + "    de la Torre #"+TorreA+ "    haca la Torre #"+TorreC+"\n"+"\n");
            contador++;
            ModAutomatic.lblt5.setText(String.valueOf(contador));
            Thread.sleep(1500);

        } else {

            //CASO DOMINIO
            TorresHanoi(Discos - 1, TorreA, TorreC, TorreB);
            ModAutomatic.txtArea1.append("       Mover Disco #"+ Discos + "    de la Torre #"+TorreA+ "    haca la Torre #"+TorreC+"\n"+"\n");
            contador++;
            ModAutomatic.lblt5.setText(String.valueOf(contador));

            Thread.sleep(1500);
            TorresHanoi(Discos - 1, TorreB, TorreA, TorreC);

        }
    }
}

package org.BeKingGo.Hanoi.modeloClases;

import org.BeKingGo.Hanoi.modelo.ModPlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Potenciadores extends JPanel implements Runnable {

    public static Thread hilo;
    int movEnY = 0;

    Color aux1 = new Color(255, 73, 65, 255);
    Color aux2 = new Color(0, 255, 2, 255);

    //ImageIcon aumeta = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/play.png");
    //ImageIcon disminuye = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/pause.png");

    //Icon aumetar = new ImageIcon(aumeta.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    //Icon disminuir = new ImageIcon(disminuye.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    JButton Incrementar;
    JButton Decrementar;

    public Potenciadores() {
        this.setLayout(null);
        componentes();

        hilo = new Thread(this);
        hilo.start();
    }

    private void componentes() {

        //LABEL QUE MUESTRA EL POTENCIADOR INCREMENTO Y DECREMENTO
        Incrementar = new JButton(": )");
        Incrementar.setBorder(null);
        Incrementar.addActionListener(Aumentar);

        Decrementar = new JButton(": (");
        Decrementar.setBorder(null);
        Decrementar.addActionListener(Disminuir);

        this.add(Incrementar);
        this.add(Decrementar);
    }

    @Override
    public void run() {
        try {
            while (true) {
                while (movEnY < 345) {

                    Thread.sleep(1000);
                    Decrementar.setVisible(false);
                    Incrementar.setVisible(true);
                    movEnY += 20;
                    //Incrementar.setIcon(aumetar);
                    Incrementar.setBounds(50, movEnY, 35, 35);
                    Incrementar.setBackground(aux2);

                    Thread.sleep(1000);
                    Incrementar.setVisible(false);
                    Decrementar.setVisible(true);
                    movEnY += 20;
                    //Incrementar.setIcon(disminuir);
                    Decrementar.setBounds(50, movEnY, 35, 35);
                    Decrementar.setBackground(aux1);

                    if (movEnY >= 275) {
                        movEnY = 0;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //ACCION DE AUMENTAR CONTADOR TIEMPO
    ActionListener Aumentar = e -> ModPlay.contTiempoPartida += 10;

    //ACCION DE DISMINUIR CONTADOR TIEMPO
    ActionListener Disminuir = e -> ModPlay.contTiempoPartida -= 10;

}

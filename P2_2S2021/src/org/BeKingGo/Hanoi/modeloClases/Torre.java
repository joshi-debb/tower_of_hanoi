package org.BeKingGo.Hanoi.modeloClases;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Torre extends JPanel {


    public Torre() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        Color aux = new Color(103, 135, 177, 255);
        g.setColor(aux);

        //base
        g.fillRoundRect(5, 190, 175,8,3,3);

        //asta
        g.fillRoundRect(90, 20, 8, 170,3,3);

    }

}

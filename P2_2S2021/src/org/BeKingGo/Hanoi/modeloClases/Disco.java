package org.BeKingGo.Hanoi.modeloClases;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Random;

public class Disco extends JPanel {

    public Disco() {
        Random rand = new Random();

        //tres colores bases
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        Color colorAnillo = new Color(r, g, b);
        //Línea 1
        Border bordejpanel = new TitledBorder(new BevelBorder(2));

        //Línea 2
        this.setBorder(bordejpanel);
        this.setBackground(colorAnillo);
    }

}

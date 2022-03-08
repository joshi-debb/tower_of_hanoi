package org.BeKingGo.Hanoi.modelo;

import org.BeKingGo.Hanoi.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModMenu extends JFrame {


    //ImageIcon salir = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/extit.png");

    private static JPanel PanelGeneral;

    public static JFrame moduloMenu;

    public ModMenu() throws IOException {

        //RECUADRO MODULO DE JUEGO
        moduloMenu = new JFrame();
        moduloMenu.setLayout(null);
        moduloMenu.setTitle("Menu Principal");
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();
        int altura = tamano.height;
        int ancho = tamano.width;
        moduloMenu.setLocation(ancho/3, altura/3);
        moduloMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        moduloMenu.setResizable(false);
        moduloMenu.setVisible(true);

        componentes();

        moduloMenu.pack();
        moduloMenu.setSize(500, 300);

    }

    private void componentes() {

        //PANEL GENERAL PARA COMPONENTES
        PanelGeneral = new JPanel();
        PanelGeneral.setLayout(null);
        Color aux2 = new Color(94, 206, 187, 228);
        PanelGeneral.setBackground(aux2);
        PanelGeneral.setBounds(0, 0, 500, 300);
        PanelGeneral.setVisible(true);
        PanelGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
        moduloMenu.add(PanelGeneral);

        //TITULO VENTANA DE CONFIGURACION
        JLabel lblt1 = new JLabel("TORRES DE HANOI");
        lblt1.setBounds(110, 20, 250, 30);
        lblt1.setFont(Hanoi.FuenteGeneralT2);
        lblt1.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt1);


        //BOTON DE NUEVO JUEGO
        JButton btnNuevoJuego = new JButton("NUEVO JUEGO");
        btnNuevoJuego.setFont(Hanoi.FuenteGeneralT1);
        btnNuevoJuego.setBounds(new Rectangle(145, 70, 190, 30));
        btnNuevoJuego.setBackground(Color.white);
        btnNuevoJuego.setBackground(Color.YELLOW);
        btnNuevoJuego.addActionListener(nuevojuego);
        btnNuevoJuego.setBorder(null);
        PanelGeneral.add(btnNuevoJuego);

        //BOTON DE JUEGO ATUOMATICO
        JButton btnJuegoAutomatico = new JButton("JUEGO AUTOMATICO");
        btnJuegoAutomatico.setFont(Hanoi.FuenteGeneralT1);
        btnJuegoAutomatico.setBounds(new Rectangle(145, 110, 190, 30));
        btnJuegoAutomatico.setBackground(Color.white);
        btnJuegoAutomatico.setBackground(Color.YELLOW);
        btnJuegoAutomatico.setBorder(null);
        btnJuegoAutomatico.addActionListener(juegoAutomatico);
        PanelGeneral.add(btnJuegoAutomatico);

        //BOTON DE TOP 5
        JButton btnTop5 = new JButton("TOP 5");
        btnTop5.setFont(Hanoi.FuenteGeneralT1);
        btnTop5.setBounds(new Rectangle(145, 150, 190, 30));
        btnTop5.setBackground(Color.white);
        btnTop5.setBackground(Color.YELLOW);
        btnTop5.addActionListener(top5);
        btnTop5.setBorder(null);
        PanelGeneral.add(btnTop5);

        //BOTON DE CONFIGURACIONES
        JButton btnConfiguraciones = new JButton("CONFIGURACIONES");
        btnConfiguraciones.setFont(Hanoi.FuenteGeneralT1);
        btnConfiguraciones.setBounds(new Rectangle(145, 190, 190, 30));
        btnConfiguraciones.setBackground(Color.white);
        btnConfiguraciones.setBackground(Color.YELLOW);
        btnConfiguraciones.setBorder(null);
        btnConfiguraciones.addActionListener(configuraciones);
        PanelGeneral.add(btnConfiguraciones);

        //BOTON SALIR
        JButton btnSalir = new JButton("SALIR");
        btnSalir.setBounds(new Rectangle(400, 220, 50, 25));
        //Icon salirr = new ImageIcon(salir.getImage().getScaledInstance(btnSalir.getWidth(),btnSalir.getHeight(),Image.SCALE_DEFAULT));
        //btnSalir.setIcon(salirr);
        btnSalir.setFont(Hanoi.FuenteGeneralT3);
        Color aux = new Color(232, 63, 49, 255);
        btnSalir.setBackground(aux);
        btnSalir.setBorder(null);
        btnSalir.addActionListener(salida);
        PanelGeneral.add(btnSalir);
/*
        //TITULO SALIR DE JUEGO
        JLabel lblt6 = new JLabel("Salir");
        lblt6.setBounds(365, 223, 75, 30);
        lblt6.setFont(FuenteGeneralT1);
        lblt6.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelGeneral.add(lblt6);
*/
    }


    //ACCION DE NUEVO JUEGO
    ActionListener nuevojuego = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                new ModPlay();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            moduloMenu.dispose();

        }
    };


    //ACCION DE JUEGO AUTOMATICO
    ActionListener juegoAutomatico = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                new ModAutomatic();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            moduloMenu.dispose();
        }
    };



    //ACCION DE TOP 5
    ActionListener top5 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                new ModTopFive();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            moduloMenu.dispose();
        }
    };

    //ACCION DE CONFIGURACION
    ActionListener configuraciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                new ModSettings();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            moduloMenu.dispose();
        }
    };


    //ACCION DE CERRAR SESION
    ActionListener salida = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            moduloMenu.dispose();
        }
    };


}

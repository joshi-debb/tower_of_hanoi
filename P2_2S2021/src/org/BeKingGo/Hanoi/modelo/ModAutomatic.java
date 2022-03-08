package org.BeKingGo.Hanoi.modelo;

import org.BeKingGo.Hanoi.Hanoi;
import org.BeKingGo.Hanoi.modeloClases.SecuenciaModoAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModAutomatic extends JFrame{

    //ImageIcon salir = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/extit.png");

    public static SecuenciaModoAutomatico TextoAutomatico;

    private static JPanel PanelGeneral;
    public static JFrame moduloAutomatico;

    public static JLabel lblt3; //TEXTO CANTIDAD DE DISCOS
    public static JLabel lblt5; //TEXTO CANTIDAD DE MOVIMIENTOS

    public static JTextArea txtArea1;



    public ModAutomatic() throws IOException {

        //RECUADRO MODULO DE JUEGO
        moduloAutomatico = new JFrame();
        moduloAutomatico.setLayout(null);
        moduloAutomatico.setTitle("Juego Automatico");
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();
        int altura = tamano.height;
        int ancho = tamano.width;
        moduloAutomatico.setLocation(ancho/3, altura/3);
        moduloAutomatico.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        moduloAutomatico.setResizable(false);
        moduloAutomatico.setVisible(true);

        componentes();

        moduloAutomatico.pack();
        moduloAutomatico.setSize(600, 400);

    }

    private void componentes() {

        //PANEL GENERAL PARA COMPONENTES
        PanelGeneral = new JPanel();
        PanelGeneral.setLayout(null);
        PanelGeneral.setBackground(Color.WHITE);
        Color aux2 = new Color(185, 150, 250, 255);
        PanelGeneral.setBackground(aux2);
        PanelGeneral.setBounds(0, 0, 600, 400);
        PanelGeneral.setVisible(true);
        PanelGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
        moduloAutomatico.add(PanelGeneral);

        //TITULO VENTANA DE JUEGO AUTOMATICO
        JLabel lblt1 = new JLabel("JUEGO AUTOMATICO");
        lblt1.setBounds(130, 20, 300, 30);
        lblt1.setFont(Hanoi.FuenteGeneralT2);
        lblt1.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt1);

        //TITULO DISCOS
        JLabel lblt2 = new JLabel("Cantidad De Discos");
        lblt2.setBounds(80, 70, 165, 30);
        lblt2.setFont(Hanoi.FuenteGeneralT1);
        lblt2.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt2);

        //TEXTO DISCOS
        lblt3 = new JLabel("000");
        lblt3.setBounds(80, 90, 165, 30);
        lblt3.setFont(Hanoi.FuenteGeneralT1);
        lblt3.setText(String.valueOf(ModPlay.CantidadDiscos));
        lblt3.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt3);

        //TITULO MOVIMIENTOS
        JLabel lblt4 = new JLabel("Movimientos");
        lblt4.setBounds(270, 70, 150, 30);
        lblt4.setFont(Hanoi.FuenteGeneralT1);
        lblt4.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt4);

        //TEXTO DISCOS
        lblt5 = new JLabel("000");
        lblt5.setBounds(270, 90, 150, 30);
        lblt5.setFont(Hanoi.FuenteGeneralT1);
        lblt5.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt5);

        //TEXTO PARA SOLUCION AUTOMATICA
        txtArea1 = new JTextArea("\n");
        txtArea1.setBounds(80, 120, 425, 185);
        txtArea1.setBackground(Color.LIGHT_GRAY);
        txtArea1.setFont(Hanoi.FuenteGeneralT3);
        PanelGeneral.add(txtArea1);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(txtArea1);
        scroll.setBounds(80, 120, 425, 185);
        scroll.setVisible(true);
        PanelGeneral.add(scroll);

        //BOTON SALIR
        JButton btnSalir = new JButton("SALIR");
        btnSalir.setBounds(new Rectangle(500, 320, 50, 25));
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
        lblt6.setBounds(438, 323, 75, 30);
        lblt6.setFont(Hanoi.FuenteGeneralT1);
        lblt6.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelGeneral.add(lblt6);
*/
        //BOTON DE INICIAR JUEGO AUTOMATICO
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setFont(Hanoi.FuenteGeneralT1);
        btnIniciar.setBounds(new Rectangle(280, 320, 130, 30));
        btnIniciar.setBackground(Color.white);
        btnIniciar.setBackground(Color.green);
        btnIniciar.setBorder(null);
        btnIniciar.addActionListener(iniciarJuegoAutomatico);
        PanelGeneral.add(btnIniciar);
    }

    //ACCION DE INICIAR EL JUEGO AUTOMATICO
    ActionListener iniciarJuegoAutomatico = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //CUENTA REGRESIVA PARA EL TIEMPO DE JUEGO
            SecuenciaModoAutomatico.contador = 0;
            TextoAutomatico = new SecuenciaModoAutomatico();
            TextoAutomatico.start();
        }
    };

    //ACCION DE CERRAR SESION
    ActionListener salida = new ActionListener() {
        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {

            SecuenciaModoAutomatico.contador = 0;

            try {
                new ModMenu();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            moduloAutomatico.dispose();
        }
    };

}


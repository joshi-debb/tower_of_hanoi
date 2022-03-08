package org.BeKingGo.Hanoi.modelo;

import org.BeKingGo.Hanoi.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModSettings extends JFrame {

    //ImageIcon salir = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/extit.png");

    JComboBox cantidadDiscosComboBox;
    JTextField txtTiempoPartida;

    private static JPanel PanelGeneral;

    public static JFrame moduloDeConfiguraciones;

    public ModSettings() throws IOException {

        //RECUADRO MODULO DE JUEGO
        moduloDeConfiguraciones = new JFrame();
        moduloDeConfiguraciones.setLayout(null);
        moduloDeConfiguraciones.setTitle("Configuraciones");
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();
        int altura = tamano.height;
        int ancho = tamano.width;
        moduloDeConfiguraciones.setLocation(ancho/3, altura/3);
        moduloDeConfiguraciones.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        moduloDeConfiguraciones.setResizable(false);
        moduloDeConfiguraciones.setVisible(true);

        componentes();

        moduloDeConfiguraciones.pack();
        moduloDeConfiguraciones.setSize(500, 300);

    }

    private void componentes() {


        //PANEL GENERAL PARA COMPONENTES
        PanelGeneral = new JPanel();
        PanelGeneral.setLayout(null);
        Color aux2 = new Color(98, 194, 246, 255);
        PanelGeneral.setBackground(aux2);
        PanelGeneral.setBounds(0, 0, 500, 300);
        PanelGeneral.setVisible(true);
        PanelGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
        moduloDeConfiguraciones.add(PanelGeneral);

        //TITULO VENTANA DE CONFIGURACION
        JLabel lblt1 = new JLabel("CONFIGURACION");
        lblt1.setBounds(130, 20, 250, 30);
        lblt1.setFont(Hanoi.FuenteGeneralT2);
        lblt1.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt1);

        //TITULO CANTIDAD DE DISCOS
        JLabel lblt2 = new JLabel("Cantidad De Discos");
        lblt2.setBounds(50, 70, 165, 30);
        lblt2.setFont(Hanoi.FuenteGeneralT1);
        lblt2.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt2);

        //CANTIDAD DE DISCOS COMBOBOX
        cantidadDiscosComboBox = new JComboBox();
        cantidadDiscosComboBox.setFont(Hanoi.FuenteGeneralT1);
        cantidadDiscosComboBox.setBackground(Color.YELLOW);
        //LLENADO DEL COMBOBOX
        for (int i = 3; i <= 7; i++) {
            cantidadDiscosComboBox.addItem(i);
        }
        cantidadDiscosComboBox.setBounds(80, 100, 110, 25);
        PanelGeneral.add(cantidadDiscosComboBox);

        //TITULO TIEMPO DE PARTIDA
        JLabel lblt3 = new JLabel("Tiempo De Partida");
        lblt3.setBounds(270, 70, 150, 30);
        lblt3.setFont(Hanoi.FuenteGeneralT1);
        lblt3.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt3);

        //TEXTO TIEMPO DE PARTIDA
        txtTiempoPartida = new JTextField("120");
        txtTiempoPartida.setBounds(275, 100, 140, 30);
        txtTiempoPartida.setFont(Hanoi.FuenteGeneralT1);
        txtTiempoPartida.setBackground(Color.YELLOW);
        txtTiempoPartida.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(txtTiempoPartida);


        //BOTON SALIR
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(new Rectangle(400, 220, 50, 25));
       // Icon salirr = new ImageIcon(salir.getImage().getScaledInstance(btnSalir.getWidth(),btnSalir.getHeight(),Image.SCALE_DEFAULT));
        //btnSalir.setIcon(salirr);
        btnSalir.setFont(Hanoi.FuenteGeneralT3);
        Color aux = new Color(232, 63, 49, 255);
        btnSalir.setBackground(aux);
        btnSalir.setBorder(null);
        btnSalir.addActionListener(salida);
        PanelGeneral.add(btnSalir);

        //TITULO SALIR DE JUEGO
        JLabel lblt6 = new JLabel("Salir");
        lblt6.setBounds(365, 223, 75, 30);
        lblt6.setFont(Hanoi.FuenteGeneralT1);
        lblt6.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelGeneral.add(lblt6);


        //BOTON DE GURADAR CONFIGURACIONES
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(Hanoi.FuenteGeneralT1);
        btnGuardar.setBounds(new Rectangle(190, 180, 130, 30));
        btnGuardar.setBackground(Color.white);
        btnGuardar.setBackground(Color.green);
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(guardarAjustes);
        PanelGeneral.add(btnGuardar);

    }


    //ACCION DEL BOTON GUARDAR
    ActionListener guardarAjustes = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                guardar(Integer.parseInt(cantidadDiscosComboBox.getSelectedItem().toString()), Integer.parseInt(txtTiempoPartida.getText()));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese tiempo en numeros enteros", null, 2);

            }
        }
    };

    public void guardar(int cantidad, int tiempo){

        ModPlay.contTiempoPartida = tiempo;
        ModPlay.CantidadDiscos = cantidad;

        try {
            new ModMenu();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        moduloDeConfiguraciones.dispose();
    }

    //ACCION DE CERRAR SESION
    ActionListener salida = new ActionListener() {
        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                new ModMenu();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            moduloDeConfiguraciones.dispose();
        }
    };


}

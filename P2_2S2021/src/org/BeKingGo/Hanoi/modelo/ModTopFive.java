package org.BeKingGo.Hanoi.modelo;

import org.BeKingGo.Hanoi.Hanoi;
import org.BeKingGo.Hanoi.modeloClases.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModTopFive extends JFrame {

    //ImageIcon salir = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/extit.png");


    //TABLA DE DATOS TOP 5
    public static JTable tablaTopFive;
    public static DefaultTableModel modeloTablaTopFive;

    private static JPanel PanelGeneral;
    public static JFrame moduloTop5;

    public ModTopFive() throws IOException {

        //RECUADRO MODULO DE JUEGO
        moduloTop5 = new JFrame();
        moduloTop5.setLayout(null);
        moduloTop5.setTitle("Top 5");
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();
        int altura = tamano.height;
        int ancho = tamano.width;
        moduloTop5.setLocation(ancho/3, altura/3);
        moduloTop5.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        moduloTop5.setResizable(false);
        moduloTop5.setVisible(true);

        componentes();

        moduloTop5.pack();
        moduloTop5.setSize(500, 300);

    }

    private void componentes() {

        //PANEL GENERAL PARA COMPONENTES
        PanelGeneral = new JPanel();
        PanelGeneral.setLayout(null);
        Color aux2 = new Color(246, 188, 140, 255);
        PanelGeneral.setBackground(aux2);
        PanelGeneral.setBounds(0, 0, 500, 300);
        PanelGeneral.setVisible(true);
        PanelGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
        moduloTop5.add(PanelGeneral);

        //TITULO VENTANA DE CONFIGURACION
        JLabel lblt1 = new JLabel("TOP 5");
        lblt1.setBounds(115, 20, 250, 30);
        lblt1.setFont(Hanoi.FuenteGeneralT2);
        lblt1.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt1);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        ordenarRecords();


        //TABLA DEL LISTADO DE GANADORES CON MEJOR RECORD
        String[] titulos = {"Nombre", "Moviemientos", "Tiempo"};
        Object[][] data = new Object[Hanoi.contadorJugadores][3];

        for (int i = 0; i < Hanoi.contadorJugadores; i++) {

            data[i][0] = Hanoi.Records[i].getNombre();
            data[i][1] = Hanoi.Records[i].getCantMov();
            data[i][2] = Hanoi.Records[i].getRecordTiempo();

        }
        modeloTablaTopFive = new DefaultTableModel(data, titulos);
        tablaTopFive = new JTable(modeloTablaTopFive);
        tablaTopFive.setRowHeight(25);
        tablaTopFive.getTableHeader().setReorderingAllowed(false);
        tablaTopFive.setBackground(Color.LIGHT_GRAY);
        tablaTopFive.setBounds(50, 65, 400, 148);
        tablaTopFive.setVisible(true);
        PanelGeneral.add(tablaTopFive);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tablaTopFive);
        scroll.setBackground(Color.LIGHT_GRAY);
        scroll.setBounds(50, 65, 400, 148);
        scroll.setVisible(true);
        PanelGeneral.add(scroll);

        //CENTRAR LOS TEXTOS DE LAS COLUMNAS DE LA TABLA
        tablaTopFive.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaTopFive.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaTopFive.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        tablaTopFive.getTableHeader().setReorderingAllowed(false);
        JTableHeader Header = tablaTopFive.getTableHeader();
        //color, fuente y fondo del encabezado
        Header.setBackground(Color.GREEN);
        Header.setForeground(Color.BLACK);
        Header.setFont(Hanoi.FuenteGeneralT4);





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
        lblt6.setFont(Hanoi.FuenteGeneralT1);
        lblt6.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelGeneral.add(lblt6);


 */

    }

    static void ordenarRecords (){

        //ORDENAMIENTO BURBUJA
            Jugador aux;
            for (int i = 0; i < Hanoi.contadorJugadores; i++) {
                for (int j = 1; j < (Hanoi.contadorJugadores - i); j++) {
                    if (Hanoi.Records[j-1].getCantMov() < Hanoi.Records[j].getCantMov()){
                        aux = Hanoi.Records[j-1];
                        Hanoi.Records[j-1] = Hanoi.Records[j];
                        Hanoi.Records[j] = aux;
                    }
                }
            }
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
            moduloTop5.dispose();
        }
    };

}

package org.BeKingGo.Hanoi.modelo;

import org.BeKingGo.Hanoi.Hanoi;
import org.BeKingGo.Hanoi.modeloClases.CuentaRegresiva;
import org.BeKingGo.Hanoi.modeloClases.Disco;
import org.BeKingGo.Hanoi.modeloClases.Potenciadores;
import org.BeKingGo.Hanoi.modeloClases.Torre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class ModPlay extends JFrame implements Serializable {

    Potenciadores panelPotenciadores;


    public static CuentaRegresiva contReversa;

    //ImageIcon menorQue = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/menorque2.png");
    //ImageIcon mayorQue = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/mayorque2.png");
    //ImageIcon salir = new ImageIcon("src/org/BeKingGo/Hanoi/imagenes/extit.png");

    //PARA TRANFERIR CONTADORES DE DISCOS, TIEMPO Y MOVIMIENTOS
    public static int contTiempoPartida = 120;
    public static int CantidadDiscos = 3;
    public static JLabel lblt4;
    public static JLabel lblt2;

    //PARA MANEJAR LA CANTIDAD DE DISCOS Y MOVIMIENTOS, DATOS DEL JUGADOR
    private int contMovimientos = 0;
    private String nombreJugador;

    //PARA PODER MOVER EL ARO
    Disco discosGeneral;

    private static JPanel PanelGeneral;
    public static JFrame moduloDeJuego;


    Torre torreA;
    Torre torreB;
    Torre torreC;

    public ModPlay() throws IOException {

        //RECUADRO MODULO DE JUEGO
        moduloDeJuego = new JFrame();
        moduloDeJuego.setLayout(null);
        moduloDeJuego.setTitle("Torres de Hanoi - FIUSAC");
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();
        int altura = tamano.height;
        int ancho = tamano.width;
        moduloDeJuego.setLocation(ancho / 4, altura / 4);
        moduloDeJuego.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        moduloDeJuego.setResizable(false);
        moduloDeJuego.setVisible(true);

        componentes();

        moduloDeJuego.pack();
        moduloDeJuego.setSize(800, 500);

    }

    //COMPONENTES DE LA VENTANA PRINCIPAL
    private void componentes() {

        //PANEL GENERAL PARA COMPONENTES
        PanelGeneral = new JPanel();
        PanelGeneral.setLayout(null);
        PanelGeneral.setBackground(Color.WHITE);
        PanelGeneral.setBounds(0, 0, 800, 500);
        PanelGeneral.setVisible(true);
        PanelGeneral.setBorder(BorderFactory.createLineBorder(Color.black));
        moduloDeJuego.add(PanelGeneral);

        //TITULO TIEMPO DE JUEGO
        JLabel lblt1 = new JLabel("Tiempo");
        lblt1.setBounds(15, 35, 150, 30);
        lblt1.setFont(Hanoi.FuenteGeneralT1);
        lblt1.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt1);

        //TEXTO TIEMPO DE JUEGO
        lblt2 = new JLabel("000");
        lblt2.setBounds(15, 60, 150, 30);
        lblt2.setFont(Hanoi.FuenteGeneralT1);
        lblt2.setText(String.valueOf(contTiempoPartida));
        lblt2.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt2);

        //TITULO MOVIMIENTOS
        JLabel lblt3 = new JLabel("Moviemintos");
        lblt3.setBounds(120, 35, 150, 30);
        lblt3.setFont(Hanoi.FuenteGeneralT1);
        lblt3.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt3);

        //TEXTO MOVIMIENTOS
        lblt4 = new JLabel("000");
        lblt4.setBounds(120, 60, 150, 30);
        lblt4.setFont(Hanoi.FuenteGeneralT1);
        lblt4.setHorizontalAlignment(SwingConstants.CENTER);
        PanelGeneral.add(lblt4);

        //BOTON DE MOVER TORRE A - TORRE C
        JButton btnA_C = new JButton("L");
        btnA_C.setBounds(new Rectangle(195, 350, 40, 40));
        //Icon menorQuee = new ImageIcon(menorQue.getImage().getScaledInstance(btnA_C.getWidth(), btnA_C.getHeight(), Image.SCALE_AREA_AVERAGING));
        //btnA_C.setIcon(menorQuee);
        btnA_C.setFont(Hanoi.FuenteGeneralT2);
        Color aux1 = new Color(93, 255, 190, 255);
        btnA_C.setBackground(aux1);
        btnA_C.setBorder(null);
        btnA_C.addActionListener(TorreA_TorreC);
        PanelGeneral.add(btnA_C);

        //BOTON DE MOVER TORRE A - TORRE B
        JButton btnA_B = new JButton("R");
        btnA_B.setBounds(new Rectangle(270, 350, 40, 40));
        //Icon mayorQuee = new ImageIcon(mayorQue.getImage().getScaledInstance(btnA_B.getWidth(), btnA_B.getHeight(), Image.SCALE_AREA_AVERAGING));
        //btnA_B.setIcon(mayorQuee);
        btnA_B.setFont(Hanoi.FuenteGeneralT2);
        Color aux2 = new Color(237, 255, 22, 255);
        btnA_B.setBackground(aux2);
        btnA_B.setBorder(null);
        btnA_B.addActionListener(TorreA_TorreB);
        PanelGeneral.add(btnA_B);

        //BOTON DE MOVER TORRE B - TORRE A
        JButton btnB_A = new JButton("L");
        btnB_A.setBounds(new Rectangle(395, 350, 40, 40));
        //btnB_A.setIcon(menorQuee);
        btnB_A.setFont(Hanoi.FuenteGeneralT2);
        Color aux3 = new Color(30, 252, 252, 255);
        btnB_A.setBackground(aux3);
        btnB_A.setBorder(null);
        btnB_A.addActionListener(TorreB_TorreA);
        PanelGeneral.add(btnB_A);

        //BOTON DE MOVER TORRE B - TORRE C
        JButton btnB_C = new JButton("R");
        btnB_C.setBounds(new Rectangle(470, 350, 40, 40));
        //btnB_C.setIcon(mayorQuee);
        btnB_C.setFont(Hanoi.FuenteGeneralT2);
        Color aux4 = new Color(174, 99, 255, 255);
        btnB_C.setBackground(aux4);
        btnB_C.setBorder(null);
        btnB_C.addActionListener(TorreB_TorreC);
        PanelGeneral.add(btnB_C);

        //BOTON DE MOVER TORRE C - TORRE B
        JButton btnC_B = new JButton("L");
        btnC_B.setBounds(new Rectangle(595, 350, 40, 40));
        //btnC_B.setIcon(menorQuee);
        btnC_B.setFont(Hanoi.FuenteGeneralT2);
        Color aux5 = new Color(255, 112, 186, 255);
        btnC_B.setBackground(aux5);
        btnC_B.setBorder(null);
        btnC_B.addActionListener(TorreC_TorreB);
        PanelGeneral.add(btnC_B);

        //BOTON DE MOVER TORRE C - TORRE A
        JButton btnC_A = new JButton("R");
        btnC_A.setBounds(new Rectangle(670, 350, 40, 40));
        //btnC_A.setIcon(mayorQuee);
        btnC_A.setFont(Hanoi.FuenteGeneralT2);
        Color aux6 = new Color(145, 189, 255, 255);
        btnC_A.setBackground(aux6);
        btnC_A.setBorder(null);
        btnC_A.addActionListener(TorreC_TorreA);
        PanelGeneral.add(btnC_A);

        //BOTON SALIR
        JButton btnSalir = new JButton("SALIR");
        btnSalir.setBounds(new Rectangle(680, 420, 50, 25));
        //Icon salirr = new ImageIcon(salir.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_DEFAULT));
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
        lblt6.setBounds(650, 423, 75, 30);
        lblt6.setFont(Hanoi.FuenteGeneralT1);
        lblt6.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelGeneral.add(lblt6);

 */

        //PANELES DE TORRES A,B,C

        torreA = new Torre();
        torreA.setBounds(160, 130, 185, 210);
        //torreA.setBorder(BorderFactory.createLineBorder(Color.black));
        agregarDiscos(CantidadDiscos);
        PanelGeneral.add(torreA);

        torreB = new Torre();
        torreB.setBounds(360, 130, 185, 210);
        //torreB.setBorder(BorderFactory.createLineBorder(Color.black));
        PanelGeneral.add(torreB);

        torreC = new Torre();
        torreC.setBounds(560, 130, 185, 210);
        //torreC.setBorder(BorderFactory.createLineBorder(Color.black));
        PanelGeneral.add(torreC);

        //CUENTA REGRESIVA PARA EL TIEMPO DE JUEGO
        contReversa = new CuentaRegresiva();
        contReversa.start();

        panelPotenciadores = new Potenciadores();
        panelPotenciadores.setBackground(Color.WHITE);
        panelPotenciadores.setBounds(25,85,120,345);
        panelPotenciadores.setVisible(true);
        PanelGeneral.add(panelPotenciadores);

    }


    //AGREGA EL NUMERO DE AROS POR DEFECTO
    public void agregarDiscos(int n) {

        Disco discos = new Disco();
        discos.setBounds(78, 170, 30, 20);
        torreA.add(discos);
        for (int i = 1; i <= n - 1; i++) {
            torreA.add(new Disco());
        }
        ordenamientoDiscos(n);
    }

    //ORDENA LOS DISCOS DESDE EL MAS GRANDE AL MAS CHICO
    private void ordenamientoDiscos(int n) {

        if (n >= 0) {
            for (int j = 1; j <= n - 1; j++) {

                //PANEL ANTERIOR
                JPanel anterior = (JPanel) torreA.getComponent(j - 1);
                //posiciones y tamaño del aro anterior
                int x = anterior.getX();
                int y = anterior.getY();
                int w = anterior.getWidth();
                int h = anterior.getHeight();

                //PANER QUE SE VA A MODIFICAR
                JPanel aroA = (JPanel) torreA.getComponent(j);
                aroA.setBounds(x, y - h, w, h);
                anterior.setBounds(x - 10, y, w + 20, h);
                torreA.setComponentZOrder(aroA, j);
                torreA.setComponentZOrder(anterior, j - 1);
            }
            ordenamientoDiscos(n - 1);
        }
    }

    //METODO VERIFICACION DE MOVIMIENTO SI SE PUEDE O NO SEGUN LA REGLA
    private boolean verificarMovimientos(Disco discoPresente, Disco discosGeneral) {

        //ANCHO DEL DISCO ACTUAL EN LA PILA
        int w = discoPresente.getWidth();

        //ANCHO DEL DISCO QUE SE QUIERE MONTAR
        int w2 = discosGeneral.getWidth();

        if (w > w2) {
            return true;
        } else {
            return false;
        }
    }

    //METODO VERIFICACION SI EL JUEGO HA TERMINADO
    public boolean verificarPilaDiscos(int n, int numeroDiscosTorre3) {

        return n == numeroDiscosTorre3;
    }

    //ACCION DE MOVER TORRE A - TORRE C
    ActionListener TorreA_TorreC = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //MOVER DESDE LA TORRE A EN OTRA TORRE
            if (torreA.getComponentCount() > 0) {
                //DISCO EN MOVIMIENTO
                discosGeneral = (Disco) torreA.getComponent(torreA.getComponentCount() - 1);
                torreA.updateUI();
            }

            //RECIBIR DE LA TORRE A EN OTRA TORRE
            if (discosGeneral != null) {

                //GUARDAR DIMENSIONES
                int x = discosGeneral.getX();
                int h = discosGeneral.getHeight();
                int w = discosGeneral.getWidth();

                if (torreC.getComponentCount() == 0) {

                    //ACOMODAR EL DISCO EN LA TORRE
                    discosGeneral.setBounds(x, 170, w, h);
                    torreC.add(discosGeneral);
                    contMovimientos++;
                    lblt4.setText(String.valueOf(contMovimientos));
                    torreC.updateUI();
                    discosGeneral = null;

                } else {
                    //CUANDO QUEDA SOLO 1 DISCO EN LA TORRE
                    Disco discoPresente = (Disco) torreC.getComponent(torreC.getComponentCount() - 1);

                    if (verificarMovimientos(discoPresente, discosGeneral)) {

                        //SI LA VERIFICACION RETORNA TRUE
                        discosGeneral.setBounds(x, 170 - (20 * torreC.getComponentCount() - 1), w, 20);
                        torreC.add(discosGeneral);
                        contMovimientos++;
                        lblt4.setText(String.valueOf(contMovimientos));
                        torreC.updateUI();
                        discosGeneral = null;

                    } else {
                        //SINO
                        JOptionPane.showMessageDialog(null, "No se puede realizar el movimiento", null, 2);
                    }
                }
            }

            //VERIFICA SI EL JUEGO TERMINA Y PEDIR AL USUARIO SU NOMBRE PARA GUARDAR SUS DATOS
            if (verificarPilaDiscos(CantidadDiscos, torreC.getComponentCount())) {

                contReversa.stop();
                Potenciadores.hilo.stop();

                nombreJugador = JOptionPane.showInputDialog(null, "Felicitaciones has Ganado! " +
                        "\n Cual es tu nombre ?", null, 1);

                ModPlay.moduloDeJuego.setVisible(false);

                if (Hanoi.contadorJugadores == 5){

                    Hanoi.contadorJugadores--;

                    Hanoi.Records[Hanoi.contadorJugadores].setNombre(String.valueOf(nombreJugador));
                    Hanoi.Records[Hanoi.contadorJugadores].setCantMov(Integer.parseInt(String.valueOf(contMovimientos)));
                    Hanoi.Records[Hanoi.contadorJugadores].setRecordTiempo(Integer.parseInt(String.valueOf(contTiempoPartida)));

                    Hanoi.contadorJugadores++;

                    //SERIALIZAR AQUI! VARIABLE CONTADOR MOV, CONTADOR TIEMPO, NOMBRE JUGADOR

                    Hanoi.serializacion("ContadorJugadores.bin", Hanoi.contadorJugadores);
                    Hanoi.serializacion("Records.bin", Hanoi.Records);

                    ModPlay.contTiempoPartida = 120;
                    try {
                        new ModMenu();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                }else if (Hanoi.contadorJugadores < 5){

                    Hanoi.Records[Hanoi.contadorJugadores].setNombre(String.valueOf(nombreJugador));
                    Hanoi.Records[Hanoi.contadorJugadores].setRecordTiempo(Integer.parseInt(String.valueOf(contTiempoPartida)));
                    Hanoi.Records[Hanoi.contadorJugadores].setCantMov(Integer.parseInt(String.valueOf(contMovimientos)));

                    Hanoi.contadorJugadores++;

                    //SERIALIZAR AQUI! VARIABLE CONTADOR MOV, CONTADOR TIEMPO, NOMBRE JUGADOR

                    Hanoi.serializacion("ContadorJugadores.bin", Hanoi.contadorJugadores);
                    Hanoi.serializacion("Records.bin", Hanoi.Records);

                    ModPlay.contTiempoPartida = 120;
                    try {
                        new ModMenu();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                }
            }
        }
    };

    //ACCION DE MOVER TORRE A - TORRE B
    ActionListener TorreA_TorreB = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //MOVER DESDE LA TORRE A EN OTRA TORRE
            if (torreA.getComponentCount() > 0) {
                //DISCO EN MOVIMIENTO
                discosGeneral = (Disco) torreA.getComponent(torreA.getComponentCount() - 1);
                torreA.updateUI();
            }

            //RECIBIR DE LA TORRE A EN OTRA TORRE
            if (discosGeneral != null) {

                //GUARDAR DIMENSIONES
                int x = discosGeneral.getX();
                int w = discosGeneral.getWidth();

                if (torreB.getComponentCount() == 0) {

                    //ACOMODAR EL DISCO EN LA TORRE
                    discosGeneral.setBounds(x, 170, w, 20);
                    torreB.add(discosGeneral);
                    contMovimientos++;
                    lblt4.setText(String.valueOf(contMovimientos));
                    torreB.updateUI();
                    discosGeneral = null;

                } else {
                    //SI LA VERIFICACION RETORNA TRUE
                    Disco discoPresente = (Disco) torreB.getComponent(torreB.getComponentCount() - 1);

                    if (verificarMovimientos(discoPresente, discosGeneral)) {
                        //SI LA VERIFICACION RETORNA TRUE
                        discosGeneral.setBounds(x, 170 - (20 * torreB.getComponentCount() - 1), w, 20);
                        torreB.add(discosGeneral);
                        contMovimientos++;
                        lblt4.setText(String.valueOf(contMovimientos));
                        torreB.updateUI();
                        discosGeneral = null;

                    } else {
                        //SINO
                        JOptionPane.showMessageDialog(null, "No se puede realizar el movimiento", null, 2);
                    }
                }
            }
        }
    };

    //ACCION DE MOVER TORRE B - TORRE A
    ActionListener TorreB_TorreA = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //MOVER DESDE LA TORRE B EN OTRA TORRE
            if (torreB.getComponentCount() > 0) {
                //DISCO EN MOVIMIENTO
                discosGeneral = (Disco) torreB.getComponent(torreB.getComponentCount() - 1);
                torreB.updateUI();
            }

            //RECIBIR DE LA TORRE B EN OTRA TORRE
            if (discosGeneral != null) {

                //GUARDAR DIMENSIONES
                int x = discosGeneral.getX();
                int h = discosGeneral.getHeight();
                int w = discosGeneral.getWidth();

                if (torreA.getComponentCount() == 0) {

                    //ACOMODAR EL DISCO EN LA TORRE
                    discosGeneral.setBounds(x, 170, w, h);
                    torreA.add(discosGeneral);
                    contMovimientos++;
                    lblt4.setText(String.valueOf(contMovimientos));
                    torreA.updateUI();
                    discosGeneral = null;

                } else {
                    //CUANDO QUEDA SOLO 1 DISCO EN LA TORRE
                    Disco discoPresente = (Disco) torreA.getComponent(torreA.getComponentCount() - 1);

                    if (verificarMovimientos(discoPresente, discosGeneral)) {

                        //SI LA VERIFICACION RETORNA TRUE
                        discosGeneral.setBounds(x, 170 - (20 * torreA.getComponentCount() - 1), w, 20);
                        torreA.add(discosGeneral);
                        contMovimientos++;
                        lblt4.setText(String.valueOf(contMovimientos));
                        torreA.updateUI();
                        discosGeneral = null;

                    } else {
                        //SINO
                        JOptionPane.showMessageDialog(null, "No se puede realizar el movimiento", null, 2);
                    }
                }
            }
        }
    };

    //ACCION DE MOVER TORRE B - TORRE C
    ActionListener TorreB_TorreC = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //MOVER DESDE LA TORRE B EN OTRA TORRE
            if (torreB.getComponentCount() > 0) {
                //DISCO EN MOVIMIENTO
                discosGeneral = (Disco) torreB.getComponent(torreB.getComponentCount() - 1);
                torreB.updateUI();
            }

            //RECIBIR DE LA TORRE B EN OTRA TORRE
            if (discosGeneral != null) {

                //GUARDAR DIMENSIONES
                int x = discosGeneral.getX();
                int w = discosGeneral.getWidth();

                if (torreC.getComponentCount() == 0) {

                    //ACOMODAR EL DISCO EN LA TORRE
                    discosGeneral.setBounds(x, 170, w, 20);
                    torreC.add(discosGeneral);
                    contMovimientos++;
                    lblt4.setText(String.valueOf(contMovimientos));
                    torreC.updateUI();
                    discosGeneral = null;

                } else {
                    //SI LA VERIFICACION RETORNA TRUE
                    Disco discoPresente = (Disco) torreC.getComponent(torreC.getComponentCount() - 1);

                    if (verificarMovimientos(discoPresente, discosGeneral)) {
                        //SI LA VERIFICACION RETORNA TRUE
                        discosGeneral.setBounds(x, 170 - (20 * torreC.getComponentCount() - 1), w, 20);
                        torreC.add(discosGeneral);
                        contMovimientos++;
                        lblt4.setText(String.valueOf(contMovimientos));
                        torreC.updateUI();
                        discosGeneral = null;

                    } else {
                        //SINO
                        JOptionPane.showMessageDialog(null, "No se puede realizar el movimiento", null, 2);
                    }
                }
            }

            //VERIFICA SI EL JUEGO TERMINA AL PONER EL BLOQUE SOBRE EL POSTE C
            if (verificarPilaDiscos(CantidadDiscos, torreC.getComponentCount())) {

                contReversa.stop();
                Potenciadores.hilo.stop();

                ModPlay.contTiempoPartida = 120;

                nombreJugador = JOptionPane.showInputDialog(null, "Felicitaciones has Ganado! " +
                        "\n Cual es tu nombre ?", null, 1);

                ModPlay.moduloDeJuego.setVisible(false);

                if (Hanoi.contadorJugadores == 5){

                    Hanoi.contadorJugadores--;

                    Hanoi.Records[Hanoi.contadorJugadores].setNombre(String.valueOf(nombreJugador));
                    Hanoi.Records[Hanoi.contadorJugadores].setCantMov(Integer.parseInt(String.valueOf(contMovimientos)));
                    Hanoi.Records[Hanoi.contadorJugadores].setRecordTiempo(Integer.parseInt(String.valueOf(contTiempoPartida)));

                    Hanoi.contadorJugadores++;

                    //SERIALIZAR AQUI! VARIABLE CONTADOR MOV, CONTADOR TIEMPO, NOMBRE JUGADOR

                    Hanoi.serializacion("ContadorJugadores.bin", Hanoi.contadorJugadores);
                    Hanoi.serializacion("Records.bin", Hanoi.Records);

                    ModPlay.contTiempoPartida = 120;
                    try {
                        new ModMenu();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                }else if (Hanoi.contadorJugadores < 5){

                    Hanoi.Records[Hanoi.contadorJugadores].setNombre(String.valueOf(nombreJugador));
                    Hanoi.Records[Hanoi.contadorJugadores].setRecordTiempo(Integer.parseInt(String.valueOf(contTiempoPartida)));
                    Hanoi.Records[Hanoi.contadorJugadores].setCantMov(Integer.parseInt(String.valueOf(contMovimientos)));

                    Hanoi.contadorJugadores++;

                    //SERIALIZAR AQUI! VARIABLE CONTADOR MOV, CONTADOR TIEMPO, NOMBRE JUGADOR

                    Hanoi.serializacion("ContadorJugadores.bin", Hanoi.contadorJugadores);
                    Hanoi.serializacion("Records.bin", Hanoi.Records);

                    try {
                        new ModMenu();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                }
            }
        }
    };

    //ACCION DE MOVER TORRE C - TORRE B
    ActionListener TorreC_TorreB = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //MOVER DESDE LA TORRE C EN OTRA TORRE
            if (torreC.getComponentCount() > 0) {
                //DISCO EN MOVIMIENTO
                discosGeneral = (Disco) torreC.getComponent(torreC.getComponentCount() - 1);
                torreC.updateUI();
            }

            //RECIBIR DE LA TORRE C EN OTRA TORRE
            if (discosGeneral != null) {

                //GUARDAR DIMENSIONES
                int x = discosGeneral.getX();
                int h = discosGeneral.getHeight();
                int w = discosGeneral.getWidth();

                if (torreB.getComponentCount() == 0) {

                    //ACOMODAR EL DISCO EN LA TORRE
                    discosGeneral.setBounds(x, 170, w, h);
                    torreB.add(discosGeneral);
                    contMovimientos++;
                    lblt4.setText(String.valueOf(contMovimientos));
                    torreB.updateUI();
                    discosGeneral = null;

                } else {
                    //CUANDO QUEDA SOLO 1 DISCO EN LA TORRE
                    Disco discoPresente = (Disco) torreB.getComponent(torreB.getComponentCount() - 1);

                    if (verificarMovimientos(discoPresente, discosGeneral)) {

                        //SI LA VERIFICACION RETORNA TRUE
                        discosGeneral.setBounds(x, 170 - (20 * torreB.getComponentCount() - 1), w, 20);
                        torreB.add(discosGeneral);
                        contMovimientos++;
                        lblt4.setText(String.valueOf(contMovimientos));
                        torreB.updateUI();
                        discosGeneral = null;

                    } else {
                        //SINO
                        JOptionPane.showMessageDialog(null, "No se puede realizar el movimiento", null, 2);
                    }
                }
            }
        }
    };

    //ACCION DE MOVER TORRE C - TORRE A
    ActionListener TorreC_TorreA = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //MOVER DESDE LA TORRE C EN OTRA TORRE
            if (torreC.getComponentCount() > 0) {
                //DISCO EN MOVIMIENTO
                discosGeneral = (Disco) torreC.getComponent(torreC.getComponentCount() - 1);
                torreC.updateUI();
            }

            //RECIBIR DE LA TORRE C EN OTRA TORRE
            if (discosGeneral != null) {

                //GUARDAR DIMENSIONES
                int x = discosGeneral.getX();
                int w = discosGeneral.getWidth();

                if (torreA.getComponentCount() == 0) {

                    //ACOMODAR EL DISCO EN LA TORRE
                    discosGeneral.setBounds(x, 170, w, 20);
                    torreA.add(discosGeneral);
                    contMovimientos++;
                    lblt4.setText(String.valueOf(contMovimientos));
                    torreA.updateUI();
                    discosGeneral = null;

                } else {
                    //SI LA VERIFICACION RETORNA TRUE
                    Disco discoPresente = (Disco) torreA.getComponent(torreA.getComponentCount() - 1);

                    if (verificarMovimientos(discoPresente, discosGeneral)) {
                        //SI LA VERIFICACION RETORNA TRUE
                        discosGeneral.setBounds(x, 170 - (20 * torreA.getComponentCount() - 1), w, 20);
                        torreA.add(discosGeneral);
                        contMovimientos++;
                        lblt4.setText(String.valueOf(contMovimientos));
                        torreA.updateUI();
                        discosGeneral = null;

                    } else {
                        //SINO
                        JOptionPane.showMessageDialog(null, "No se puede realizar el movimiento", null, 2);
                    }
                }
            }
        }
    };

    //ACCION DE CERRAR SESION
    ActionListener salida = new ActionListener() {
        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                contReversa.stop();
                Potenciadores.hilo.stop();

                ModPlay.contTiempoPartida = 120;

                new ModMenu();

            } catch (IOException exception) {
                exception.printStackTrace();
            }
            moduloDeJuego.dispose();
        }
    };


}

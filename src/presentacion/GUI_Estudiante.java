package presentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Estudiante extends JFrame {

    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JTextArea textoExpectativa;
    private Titulos titulo;
    private ImageIcon imagen;
    private JLabel labelImagen;
    private Escucha escucha;

    public GUI_Estudiante() {
        initGUI();
        //default window configuration
        this.setTitle("Mi ventana");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //GUI_Estudiante miGUI = new GUI_Estudiante();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Estudiante miGUI = new GUI_Estudiante();
            }
        });
    }

    private void initGUI() {
        //Set up Container and Layout
        //Create Listener and Control Objects
        escucha = new Escucha();

        //Set up JComponents
        titulo = new Titulos("Hola soy Estefania, oprime los botones", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        miFoto = new JButton("Este soy");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Mi Hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que");
        misExpectativas.addActionListener(escucha);
        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco más de mí",
                                                              TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER,
                                                              new Font("calibri", Font.BOLD + Font.ITALIC, 20),
                                                              Color.BLACK));
        this.add(panelDatos, BorderLayout.CENTER);
        labelImagen = new JLabel();
        textoExpectativa = new JTextArea(15,20);
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent objectEvent) {
            panelDatos.removeAll();
            if(objectEvent.getSource() == miFoto){
                imagen = new ImageIcon(getClass().getResource("/recursos/yo.jpeg"));
                labelImagen.setIcon(imagen);
                panelDatos.add(labelImagen);
            }else{
                if(objectEvent.getSource() == miHobby){
                    imagen = new ImageIcon(getClass().getResource("/recursos/pasear.jpeg"));

                    labelImagen.setIcon(imagen);
                    panelDatos.add(labelImagen);
                }else{
                    textoExpectativa.setText("Tengo conocimientos en java, en este curso quiero y \n" +
                                            "espero reforzar mis conocimientos sobre este lenguaje \n" +
                                            "y ser una muy buena desarrolladora de software.");
                    textoExpectativa.setBackground(null);
                    textoExpectativa.setFont(new Font("arial",Font.PLAIN+ Font.ITALIC,20));
                    panelDatos.add(textoExpectativa);
                }
            }
            revalidate();
            repaint();
        }
    }
}


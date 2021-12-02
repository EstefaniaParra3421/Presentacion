package presentacion;

import javax.swing.*;
import java.awt.*;

public class Titulos extends JLabel{

    public Titulos(String titulo, Color colorFondo){
        this.setText(titulo);
        this.setBackground(colorFondo);
        this.setForeground(Color.white);
        this.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setVisible(true);
    }
}

package gui;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    Dimension screenSize;
    String komunikat;
    public InfoPanel(Dimension screenSize) {
        super();
        this.screenSize = screenSize;
        this.komunikat = "";
        setVisible(false);
        setMaximumSize(new Dimension(screenSize.width/2,screenSize.height/10));
    }

    public void trafiony() {
        komunikat = "TRAFIONY";
        repaint();
    }

    public void pudlo() {
        komunikat = "PUDŁO";
        repaint();
    }

    public void trafionyZatopiony() {
        komunikat = "TRAFIONY ZATOPIONY";
        repaint();
    }

    public void juzTuStrzelales() {
        komunikat = "JUŻ TU STRZELAŁEŚ";
        repaint();
    }

    public void wygrales() {
        komunikat = "WYGRAŁEŚ!!!";
        repaint();
    }

    public void przegrales() {
        komunikat = "PRZEGRAŁEŚ!!!";
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(255,0,0));
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString(komunikat,screenSize.width/5,screenSize.height/20);
    }
}

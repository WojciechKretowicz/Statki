package gui;

import javax.swing.*;
import java.awt.*;

public class FinalPanel extends JPanel {
    Dimension screenSize;
    public FinalPanel(Dimension screenSize) {
        super();
        komunikat = "";
        setVisible(false);
        this.screenSize = screenSize;
    }

    private String komunikat;

    public void wygrales() {
        komunikat = "WYGRAŁEŚ!!!";
        setBackground(new Color(0,255,0));
        repaint();
    }

    public void przegrales() {
        komunikat = "PRZEGRAŁEŚ!!!";
        setBackground(new Color(255,0,0));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(g.getFont().deriveFont(50.0f));
        g.drawString(komunikat,screenSize.width/3,screenSize.height/2);
    }
}

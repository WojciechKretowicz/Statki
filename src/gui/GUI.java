package gui;

import Engine.General;
import gui.map.MapPanel;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {
    private JFrame frame;
    private Dimension screenSize;
    private JPanel backgroundPanel;
    private JButton graj;
    private JPanel menuPanel;
    private JTextField proby;
    private MapPanel mapPanel;
    private InfoPanel info;

    public GUI() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("Statki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);

        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(79, 0, 0));
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(125, 63, 112));
        menuPanel.setMaximumSize(new Dimension(screenSize.width / 3, screenSize.height));

        graj = new JButton("GRAJ");
        graj.setPreferredSize(new Dimension(screenSize.width / 6, screenSize.height / 10));
        graj.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        menuPanel.add(graj);


        proby = new JTextField("Ile chcesz mieć prób?");
        proby.setPreferredSize(new Dimension(screenSize.width / 6, screenSize.height / 10));
        proby.setFont(proby.getFont().deriveFont(18.0f));
        menuPanel.add(proby);

        backgroundPanel.add(menuPanel);

        info = new InfoPanel(screenSize);

        mapPanel = new MapPanel(screenSize, info);
        backgroundPanel.add(mapPanel);

        backgroundPanel.add(info);

        frame.add(backgroundPanel);
    }

    public void makeGUI() {
        frame.setVisible(true);
        frame.revalidate();
    }

    public void startGame() {
        String text = proby.getText();
        General.setStrzaly(text);
        menuPanel.setVisible(false);
        mapPanel.setVisible(true);
        info.setVisible(true);
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }
}

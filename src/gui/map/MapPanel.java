package gui.map;

import gui.InfoPanel;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private Tile tiles [];
    public MapPanel(Dimension screenSize, InfoPanel info) {
        super();
        tiles = new Tile[100];
        setMaximumSize(new Dimension(screenSize.width/2, screenSize.width/2));
        setBackground(new Color(125,63,112));
        setVisible(false);

        for(int i = 0; i<100; i++) {
            Tile tile = new Tile(i%10,i/10, screenSize, info, this);
            add(tile);
            tiles[i] = tile;
        }
    }

    public Tile[] getTiles() {
        return tiles;
    }
}

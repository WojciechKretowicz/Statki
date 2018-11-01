package Engine;

import gui.map.Tile;

import java.awt.*;

public class Statek {
    private int hp;
    private Tile [] tiles;
    public Statek(int hp, Tile [] tiles) {
        this.hp = hp;
        this.tiles = tiles;
    }

    public void fire(Tile tile) {
        hp--;
        if(hp > 0)
            tile.setBackground(new Color(255,165,0));
        else {
            for(Tile t : tiles)
                t.setBackground(new Color(255,0,0));
        }
    }

    public int getHp() {
        return hp;
    }
}

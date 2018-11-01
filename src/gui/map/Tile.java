package gui.map;

import Engine.General;
import Engine.Statek;
import gui.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel {
    private int x,y;
    private boolean clicked;
    private boolean visited;
    private Statek statek;
    private MapPanel mapPanel;
    public Tile(int x, int y, Dimension screenSize, InfoPanel info, MapPanel mapPanel) {
        super();
        this.mapPanel = mapPanel;
        this.x = x;
        this.y = y;
        statek = null;
        clicked = false;
        visited = false;
        setBackground(new Color(125,87,54));
        setPreferredSize(new Dimension(screenSize.width/22,screenSize.width/22));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(clicked) {
                    info.juzTuStrzelales();
                    return;
                }
                clicked = true;
                General.subStrzaly();
                if(statek == null) {
                    setBackground(new Color(0,0,0));
                    if(General.getStrzaly() > 0)
                        info.pudlo();
                    else {
                        info.przegrales();
                        //////////////////////////////////
                    }
                }
                else {
                    statek.fire(Tile.this);
                    General.subPolaStatkow();
                    if(statek.getHp() > 0)
                        info.trafiony();
                    else {
                        info.trafionyZatopiony();
                        mark(statek);
                    }

                    if(General.getStrzaly() == 0 && General.getPolaStatkow() > 0)
                        info.przegrales();
                    else if(General.getPolaStatkow() == 0)
                        info.wygrales();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(!clicked)
                    setBackground(new Color(255,255,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!clicked)
                    setBackground(new Color(125,87,54));
            }
        });
    }

    public static int index(int x, int y) {
        return y*10 + x;
    }


    private void mark(Statek s) {
        if(visited)
            return;
        visited = true;
        if(statek == null) {
            setBackground(new Color(0, 0, 0));
            clicked = true;
            return;
        }
        if(statek != s)
            return;
        if(x > 0 && y > 0)
            mapPanel.getTiles()[index(x-1,y-1)].mark(s);
        if(x < 9 && y < 9)
            mapPanel.getTiles()[index(x+1,y+1)].mark(s);
        if(x > 0 && y < 9)
            mapPanel.getTiles()[index(x-1,y+1)].mark(s);
        if(x < 9 && y > 0)
            mapPanel.getTiles()[index(x+1,y-1)].mark(s);
        if(x > 0)
            mapPanel.getTiles()[index(x-1,y)].mark(s);
        if(x < 9)
            mapPanel.getTiles()[index(x+1,y)].mark(s);
        if(y > 0)
            mapPanel.getTiles()[index(x,y-1)].mark(s);
        if(y < 9)
            mapPanel.getTiles()[index(x,y+1)].mark(s);
    }

    public Statek getStatek() {
        return statek;
    }

    public void setStatek(Statek statek) {
        this.statek = statek;
    }
}

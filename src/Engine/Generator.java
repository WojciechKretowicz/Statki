package Engine;

import gui.map.MapPanel;
import gui.map.Tile;

import java.util.Random;

public class Generator {
    MapPanel mapPanel;
    public void generate(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        Statek statki [] = new Statek[10];

        int pos [];
        Tile tiles [];
        int index = 0;
        for(int hp = 4; hp > 0; hp --) {
            for(int times = 0; times < 5 - hp; times++) {
                tiles = new Tile[hp];
                pos = search(hp);
                for(int i=0; i < hp; i++)
                    tiles[i] = mapPanel.getTiles()[pos[i]];
                statki[index] = new Statek(hp,tiles);
                for(int i=0; i < hp; i++)
                    tiles[i].setStatek(statki[index]);
                index++;
            }
        }


    }

    private int [] search(int n) {
        Random random = new Random();
        int x,y,direction,index;
        int [] result = new int[n];
        while(true) {
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(mapPanel.getTiles()[Tile.index(x,y)].getStatek() != null) {
                continue;
            }

            for(int i = 0; i < 5; i++) {
                direction = random.nextInt(4);
                if(check(x,y,n,direction)) {
                    index = 0;
                    if(direction == 0) {
                        for(int j = x; j < x+n; j++) {
                            result[index] = Tile.index(j,y);
                            index++;
                        }
                    }
                    else if(direction == 1) {
                        for(int j = y; j < y+n; j++) {
                            result[index] = Tile.index(x,j);
                            index++;
                        }
                    }
                    else if(direction == 2) {
                        for(int j = x; j > x - n; j--) {
                            result[index] = Tile.index(j,y);
                            index++;
                        }
                    }
                    else {
                        for(int j = y; j > y- n; j--) {
                            result[index] = Tile.index(x,j);
                            index++;
                        }
                    }
                    return result;
                }
            }


        }
    }

    private boolean check(int x,int y,int n,int direction) {
        if(direction == 0) {
            for(int i = x; i < x+n; i++) {
                if(i > 9)
                    return false;
                if(mapPanel.getTiles()[Tile.index(i,y)].getStatek() != null)
                    return false;
                if(!checkNear(i,y))
                    return false;
            }
            return true;
        }
        else if(direction == 1) {
            for(int i = y; i < y+n; i++) {
                if(i > 9)
                    return false;
                if(mapPanel.getTiles()[Tile.index(x,i)].getStatek() != null)
                    return false;
                if(!checkNear(x,i))
                    return false;
            }
            return true;
        }
        else if(direction == 2) {
            for(int i = x; i > x-n; i--) {
                if(i < 0)
                    return false;
                if(mapPanel.getTiles()[Tile.index(i,y)].getStatek() != null)
                    return false;
                if(!checkNear(i,y))
                    return false;
            }
            return true;
        }
        else {
            for(int i = y; i > y -n; i--) {
                if(i < 0)
                    return false;
                if(mapPanel.getTiles()[Tile.index(x,i)].getStatek() != null)
                    return false;
                if(!checkNear(x,i))
                    return false;
            }
            return true;
        }
    }

    private boolean checkNear(int x,int y) {
        if(x > 0 && y > 0) {
            if (mapPanel.getTiles()[Tile.index(x - 1, y - 1)].getStatek() != null)
                return false;
        }
        if(x < 9 && y < 9) {
            if (mapPanel.getTiles()[Tile.index(x + 1, y + 1)].getStatek() != null)
                return false;
        }
        if(x > 0 && y < 9) {
            if (mapPanel.getTiles()[Tile.index(x - 1, y + 1)].getStatek() != null)
                return false;
        }
        if(x < 9 && y > 0) {
            if (mapPanel.getTiles()[Tile.index(x + 1, y - 1)].getStatek() != null)
                return false;
        }
        if(x > 0) {
            if (mapPanel.getTiles()[Tile.index(x - 1, y)].getStatek() != null)
                return false;
        }
        if(x < 9) {
            if (mapPanel.getTiles()[Tile.index(x + 1, y)].getStatek() != null)
                return false;
        }
        if(y > 0) {
            if (mapPanel.getTiles()[Tile.index(x, y - 1)].getStatek() != null)
                return false;
        }
        if(y < 9) {
            if (mapPanel.getTiles()[Tile.index(x, y + 1)].getStatek() != null)
                return false;
        }


        return true;

    }

}

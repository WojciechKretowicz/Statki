package main;

import Engine.Generator;
import gui.GUI;

public class Statki {
    public static void main(String [] args) {
        GUI gui = new GUI();
        gui.makeGUI();
        Generator generator = new Generator();
        generator.generate(gui.getMapPanel());
    }
}

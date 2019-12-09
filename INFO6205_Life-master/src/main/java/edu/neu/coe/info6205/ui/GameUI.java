package edu.neu.coe.info6205.ui;

import jdk.nashorn.internal.runtime.ScriptObject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUI extends JFrame{
    public int maxWidth = 150, maxLength = 50;
    public int pre_x = 50, pre_y = 25, init_x = 50, init_y = 25, x_position = 0, y_position = 0;

    public int[][] cell = new int[51][151];
    public List<JButton> btns = new ArrayList<>();

    JPanel panel = new JPanel();

    private static GameUI ui = new GameUI();
    public static GameUI createUI(){
        return ui;
    }


    private GameUI() {
        Border cellborder = BorderFactory.createLineBorder(Color.black);
        setSize(2000, 600);
        getContentPane().setLayout(null);
        panel.setLayout(new GridLayout(maxLength, maxWidth));
        //set the size of each grid
        panel.setBounds(10, 10, maxWidth * 10, maxLength * 10);
        getContentPane().add(panel);
        //show position of the points
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxWidth; j++) {
                JButton btn = new JButton();
                btn.setBackground(null);
                // set blank grid
                if (cell[i][j] == 0) { btn.setBackground(Color.white); }
                btn.setOpaque(true);
                btn.setBorder(cellborder);
                panel.add(btn);
                btns.add(btn);
            }
        }
    }
}

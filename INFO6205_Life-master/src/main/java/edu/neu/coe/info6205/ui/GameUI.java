package edu.neu.coe.info6205.ui;

import jdk.nashorn.internal.runtime.ScriptObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUI extends JFrame{
    public int maxWidth = 150;
    public int maxLength = 50;
    public int pre_x = 50;
    public int pre_y = 25;
    public int init_x = 50;
    public int init_y = 25;
    public int x_position = 0;
    public int y_position = 0;

    public int[][] cell = new int[maxLength][maxWidth];
    public List<JButton> btns = new ArrayList<>();

    JPanel panel = new JPanel();

    private static GameUI ui = new GameUI();
    public static GameUI createUI(){
        return ui;
    }


    private GameUI() {
        panel.setName("Game of Life");
        setSize(2000, 600);
        getContentPane().setLayout(null);
        panel.setLayout(new GridLayout(maxLength, maxWidth));
        panel.setBounds(10, 10, maxWidth * 10, maxLength * 10);
        getContentPane().add(panel);
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxWidth; j++) {
                JButton btn = new JButton();
                btn.setBackground(null);
                if (cell[i][j] == 0) { btn.setBackground(Color.white); }
                btn.setOpaque(true);
                btn.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(btn);
                btns.add(btn);
            }
        }
    }
}

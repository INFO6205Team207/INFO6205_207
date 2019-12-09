package edu.neu.coe.info6205.life.base;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUI extends JFrame{
    JPanel panel = new JPanel();
    public static int g0X = 50;
    public static int g0Y = 25;
    public static int startX = 50;
    public static int startY = 25;
    public static int x_position = 0;
    public static int y_position = 0;

    private static int[][] cell = new int[51][201];
    public  static int maxWidth = 200;
    public  static int maxLength = 50;
    public List<JLabel> btns = new ArrayList<>();

    private static GameUI gui = new GameUI();
    public static GameUI getGUI(){
        return gui;
    }


    private GameUI() {
        setName("Game of Live");
        setSize(2000, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        panel.setLayout(new GridLayout(maxLength, maxWidth));
        panel.setBounds(10, 10, maxWidth * 10, maxLength * 10);
        getContentPane().add(panel);
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxWidth; j++) {
                JLabel btn = new JLabel();
                Color color = null;
                if (cell[i][j] == 0) {
                    color = Color.white;
                }
                btn.setBackground(color);
                btn.setOpaque(true);
                btn.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(btn);
                btns.add(btn);
            }
        }
    }
}

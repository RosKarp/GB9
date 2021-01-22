package ru.GeekBrains.Rostislav.lesson8TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class GraphicsTicTacToe {

    private static final int SIZE = 3; // размер поля SIZExSIZE
    private static final char[][] map = new char[SIZE][SIZE];
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final JButton[][] jbs = new JButton[SIZE][SIZE];

    private static void initializeGame() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }

    static public class MyWindow extends JFrame {
        public MyWindow() {
            setBounds(500,500,400,400);
            setTitle("TicTacToe");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(new GridLayout(SIZE, SIZE));
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    jbs[i][j] = new JButton();
                    jbs[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(!checkEndGame(DOT_X) && !checkEndGame(DOT_O)) {
                                if(((JButton)e.getSource()).getText().equals("0") || ((JButton)e.getSource()).getText().equals("X")) {
                                    System.out.println("Клетка занята, выберите другую клетку.");
                                }
                                if (!((JButton)e.getSource()).getText().equals("0")) {
                                    ((JButton)e.getSource()).setText("X");
                                }
                                humanTurn();
                                checkEndGame(DOT_X);
                                if(!checkEndGame(DOT_X)) {
                                    computerTurn();
                                    checkEndGame(DOT_O);
                                }
                            }
                        }
                    });
                    add(jbs[i][j]);
                    if((jbs[i][j].getText()).equals("X")) {
                        map[i][j] = DOT_X;
                    }
                }
            }
            setVisible(true);
        }
    }

    private static void humanTurn() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(jbs[i][j].getText().equals("X")){
                    map[i][j] = DOT_X;
                }
            }
        }
    }

    private static void computerTurn() {
        int rowIndex;
        int colIndex;
        Random rand = new Random();
        do {
                rowIndex = rand.nextInt(SIZE);
                colIndex = rand.nextInt(SIZE);
            } while ((jbs[rowIndex][colIndex].getText()).equals("X") || (jbs[rowIndex][colIndex].getText()).equals("0"));
            map[rowIndex][colIndex] = DOT_O;
            jbs[rowIndex][colIndex].setText("0");
    }

    private static boolean checkWin(char symbol) {

            for (int i = 0; i < map.length; i++) {
                int k = 0;
                for (int j = 0; j < map.length; j++) {

                    if (map[i][j] == symbol) {
                        k++;
                    }
                    if (k == SIZE) return true; //проверка победы по строкам
                }
            }
            for (int i = 0; i < map.length; i++) {
                int k = 0;
                for (int j = 0; j < map.length; j++) {

                    if (map[j][i] == symbol) {
                        k++;
                    }
                    if (k == SIZE) return true; //проверка победы по столбцам
                }
            }
            int k = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i][i] == symbol) {
                    k++;
                }
                if (k == SIZE) return true; //проверка победы по диагонали 1
            }
            k = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i][map.length - 1 - i] == symbol) {
                    k++;
                }
                if (k == SIZE) return true; //проверка победы по диагонали 2
            }
                return false;
    }

    private static boolean isMapFull() {
        for (char[] rows : map) {
            for (char cellValue : rows) {
                if(cellValue == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkEndGame(char symbol) {
        if(checkWin(symbol)) {
            System.out.println(symbol == DOT_X ? "Человек победил!" : "Компьютер победил!");
            return true;
        }
        if(isMapFull() && !(checkWin(DOT_X)) && !(checkWin(DOT_O))) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        initializeGame();
        new MyWindow();
    }
}

package ru.GeekBrains.Rostislav.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 5; // размер поля SIZExSIZE
    private static final int SIZE_OF_WIN = 4; // победа при SIZE_OF_WIN символов в ряд
    private static final char[][] map = new char[SIZE][SIZE];
    private static final char[][] partOfmap = new char[SIZE_OF_WIN][SIZE_OF_WIN];

    private static int numberOfHumanTurn = 0;
    private static boolean computerHasTurn = false;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
    initializeGame();
    printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)) break;

            computerTurn();
            printMap();
            if (checkEndGame(DOT_O)) break;
        }
    }

    private static boolean checkEndGame(char symbol) {
        if(checkWin(symbol)) {
            System.out.println(symbol == DOT_X ? "Человек победил!" : "Компьютер победил!");
            return true;
        }
        if(isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static void humanTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        do {
            System.out.print("Введите номер строки: ");
            if(!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            rowIndex = SCANNER.nextInt() - 1;

            System.out.print("Введите номер столбца: ");
            if(!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            colIndex = SCANNER.nextInt() - 1;
        } while (!isCellValid(rowIndex, colIndex, DOT_X));

        map[rowIndex][colIndex] = DOT_X;

        numberOfHumanTurn++;
    }

    private static boolean isCellValid(int rowIndex, int colIndex, char symbol) {
        if(!isArrayIndexValid(rowIndex) || !isArrayIndexValid(colIndex)) {
            if (isHumanTurn(symbol)) {
                System.out.println("Индексы строки и колонки должны быть в диапазоне от 1 до " + SIZE);
            }

            return false;
        }
        if(map[rowIndex][colIndex] != DOT_EMPTY) {
            if (isHumanTurn(symbol)) {
                System.out.println("Данная ячейка уже занята!");
            }
            return false;
        }
        return true;
    }

    private static boolean isHumanTurn(char symbol) {
        if (symbol == DOT_X) {
            return true;
        }
        return false;
    }

    private static boolean isArrayIndexValid(int Index) {
        return Index >= 0 && Index < SIZE;
    }

    private static void printMap() {
        printHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int rowIndex = 0; rowIndex < SIZE ; rowIndex++) {
            System.out.print((rowIndex + 1) + " " );
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                System.out.print(map[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initializeGame() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }

    private static void computerTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        Random rand = new Random();
        if (numberOfHumanTurn < SIZE_OF_WIN - 1) { //пока человек далек от победы ПК валяет дурака
            do {
                rowIndex = rand.nextInt(SIZE);
                colIndex = rand.nextInt(SIZE);
            } while (!isCellValid(rowIndex, colIndex, DOT_O));

            map[rowIndex][colIndex] = DOT_O;
        }
        else {   // человек близок к победе
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(map[i][j] == DOT_EMPTY) {
                        map[i][j] = DOT_X; //проверка по всем пустым полям, может ли человек победить в одном из них,
                        if(checkWin(DOT_X) && !computerHasTurn) { //чтобы ПК не ходил дважды подряд
                                map[i][j] = DOT_O; // если может, то туда ходит ПК
                            computerHasTurn = true;
                        } // Однако ПК не слишком умен, он не блокирует возможность победы человека с двух концов ряда
                         else
                        {
                            map[i][j] = DOT_EMPTY;
                        }
                    }
                }
            }
            if(!computerHasTurn) {  //чтобы ПК не ходил дважды подряд
                do { // человек упустил победу, ПК продолжает валять дурака
                    rowIndex = rand.nextInt(SIZE);
                    colIndex = rand.nextInt(SIZE);
                } while (!isCellValid(rowIndex, colIndex, DOT_O));

                map[rowIndex][colIndex] = DOT_O;
            }
        }
        computerHasTurn = false;
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
    private static boolean checkWin(char symbol) {
        /*if(map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if(map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if(map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        if(map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if(map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if(map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        if(map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if(map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;*/

        if (SIZE == 3) { //проверка для простого случая
            for (int i = 0; i < map.length; i++) {
                int k = 0;
                for (int j = 0; j < map.length; j++) {

                    if(map[i][j] == symbol) {
                        k++;
                    }
                    if(k == SIZE) return true; //проверка победы по строкам
                }
            }
            for (int i = 0; i < map.length; i++) {
                int k = 0;
                for (int j = 0; j < map.length; j++) {

                    if(map[j][i] == symbol) {
                        k++;
                    }
                    if(k == SIZE) return true; //проверка победы по столбцам
                }
            }
            int k = 0;
            for (int i = 0; i < map.length; i++) {
                if(map[i][i] == symbol) {
                    k++;
                }
                if(k == SIZE) return true; //проверка победы по диагонали 1
            }
            k = 0;
            for (int i = 0; i < map.length; i++) {
                if(map[i][map.length - 1 - i] == symbol) {
                    k++;
                }
                if(k == SIZE) return true; //проверка победы по диагонали 2
            }
        }
        if (SIZE > 3) {  //проверка в общем случае
            for (int i = 0; i <= map.length - partOfmap.length; i++) {
                for (int j = 0; j <= map.length - partOfmap.length ; j++) {
                    for (int k = 0; k < partOfmap.length; k++) {
                        for (int l = 0; l < partOfmap.length; l++) {
                            partOfmap[k][l] = map[k + i][l + j]; //перемещаем partOfmap внутри map и заполняем его фрагментами map
                        }
                    }
                    for (int m = 0; m < partOfmap.length; m++) {
                        int k = 0;
                        for (int n = 0; n < partOfmap.length; n++) {

                            if(partOfmap[m][n] == symbol) {
                                k++;
                            }
                            if(k == SIZE_OF_WIN) return true; //проверка победы по строкам
                        }
                    }
                    for (int m = 0; m < partOfmap.length; m++) {
                        int k = 0;
                        for (int n = 0; n < partOfmap.length; n++) {

                            if(partOfmap[n][m] == symbol) {
                                k++;
                            }
                            if(k == SIZE_OF_WIN) return true; //проверка победы по столбцам
                        }
                    }
                    int k = 0;
                    for (int m = 0; m < partOfmap.length; m++) {
                        if(partOfmap[m][m] == symbol) {
                            k++;
                        }
                        if(k == SIZE_OF_WIN) return true; //проверка победы по диагонали 1
                    }
                    k = 0;
                    for (int m = 0; m < partOfmap.length; m++) {
                        if(partOfmap[m][partOfmap.length - 1 - m] == symbol) {
                            k++;
                        }
                        if(k == SIZE_OF_WIN) return true; //проверка победы по диагонали 2
                    }
                }
            }
        }
        return false;
    }
} // Приношу извинения за короткие имена переменных, сейчас есть срочные дела :)

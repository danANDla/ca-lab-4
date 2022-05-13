package utils;

import entities.Point;
import entities.functions.FunctionManager;

import java.util.Locale;

public class Asker {
    private IOutil io;
    private FunctionManager functionManager;

    public Asker(IOutil io, FunctionManager functionManager) {
        this.io = io;
        this.functionManager = functionManager;
    }

    private String getNonEmpty() {
        String str;
        io.printArrow();
        str = io.readLine().trim();
        while (str.equals("")) {
            str = io.readLine().trim();
        }
        return str;
    }

    public int askFunction(){
        int sysid = 0;
        boolean valid = false;
        io.printText("Выберите функию:");
        for(int i = 0; i < functionManager.getAllFunctions().size(); ++i){
            System.out.printf("(%d) ", i+1);
            io.printText(functionManager.getFunc(i).toString());
        }
        io.printText("(0) отмена");
        while (!valid) {
            try {
                sysid = Integer.parseInt(getNonEmpty()) - 1;
                valid = true;
                if (sysid < -1 || sysid >= functionManager.getAllFunctions().size()) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return sysid;
    }

    public int askMode() {
        int mode = 0;
        boolean valid = false;
        io.printDivider();
        io.printText("Выберите режим:\n" +
                "(1) сгенирировать набор точек\n" +
                "(2) ввести точки вручную\n" +
                "(0) выход из приложения\n");
        while (!valid) {
            try {
                mode = Integer.parseInt(getNonEmpty());
                valid = true;
                if (mode < 0 || mode > 2) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return mode;
    }

    public Point[] askPoints(){
        io.printText("введите количество точек");
        int k = -1;
        boolean valid = false;
        while (!valid) {
            try {
                k = Integer.parseInt(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }

        io.printText("введите координаты точек");
        Point[] points = new Point[k];
        for (int i = 0; i < k; i++) {
            boolean validrow = false;
            while (!validrow) {
                String row = getNonEmpty();
                String[] numbers = row.trim().toLowerCase(Locale.ROOT).split("\\s+");
                if (numbers.length !=  2) {
                    io.printError("Неверное количество введенных чисел");
                    continue;
                }
                boolean badNum = false;
                try {
                    points[i] = new Point();
                    points[i].setX(Double.parseDouble(numbers[0]));
                    points[i].setY(Double.parseDouble(numbers[1]));
                } catch (NumberFormatException e) {
                    io.printError("Неправильный формат вещественного числа");
                    badNum = true;
                }
                validrow = !badNum;
            }
        }

        return points;
    }

}

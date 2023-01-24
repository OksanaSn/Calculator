package com.company;

import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\Oksana\\Desktop\\input.txt");
        Scanner sc1 = new Scanner(file);
        Scanner sc2 = new Scanner(file);
        FileWriter fw = new FileWriter("C:\\Users\\Oksana\\Desktop\\output.txt");
        while (sc1.hasNext()) {
            try {
                double a = sc1.nextDouble();
                String op = sc1.next();
                double b = sc1.nextDouble();
                String ops = "+-*/";
                String result = "";
                if (!ops.contains(op)) result = "Operation Error!";
                switch (op) {
                    case "+": result = Double.toString(a + b); break;
                    case "-": result = Double.toString(a - b); break;
                    case "*": result = Double.toString(a * b); break;
                    case "/": result = (b == 0 ? "Error! Division by zero" : Double.toString(a / b)); break;
                }
                fw.append(sc2.nextLine() + " = " + result + "\n");
                fw.flush();
            } catch (Exception ex) {
                fw.append(sc2.nextLine() + " = " + "Error! Not number" + "\n");
                fw.flush();
                sc1.nextLine();
            }
        }
        fw.close(); sc1.close(); sc2.close();


    }
}

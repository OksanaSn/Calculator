package com.company;

import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File inputFile = new File("C:\\Users\\Oksana\\Desktop\\input.txt");
        File outputFile = new File("C:\\Users\\Oksana\\Desktop\\output.txt");
        try (Scanner sc = new Scanner(inputFile);
             FileWriter fw = new FileWriter(outputFile, false);) {

            String str = sc.nextLine();
            String[] words = str.split(" ");
            double a = 0, b = 0;
            try {
                a = Double.parseDouble(words[0]);
                b = Double.parseDouble(words[2]);
            } catch (NumberFormatException e) {
                fw.write("Error! Not number");
                fw.flush();
                return;
            }
            try {
                if (words[1].equals("+")) {
                    fw.write(String.valueOf(a + b));
                    fw.flush();
                    return;
                }
                if (words[1].equals("-")) {
                    fw.write(String.valueOf(a - b));
                    fw.flush();
                    return;
                }
                if (words[1].equals("*")) {
                    fw.write(String.valueOf(a * b));
                    fw.flush();
                    return;
                }
                if (words[1].equals("/")) {
                    if (b == 0d) throw new ArithmeticException("Error! Division by zero");
                    fw.write(String.valueOf(a / b));
                    fw.flush();
                    return;
                }
                fw.write("Operation Error!");
                fw.flush();

            } catch (ArithmeticException e) {
                fw.write(e.getMessage());
                fw.flush();
                return;
            }
        }


    }
}

package com.calc;

import java.util.Scanner;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multi(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Divide Error");
        } else {
            return a / b;
        }
    }

    public int calculate(String operator, int a, int b) throws Exception {
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return minus(a, b);
            case "*":
                return multi(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new Exception("Unsupported Operator");
        }
    }

    public String[] parseInput(String input) throws Exception {
        String[] parts = input.trim().split(" ");
        if (parts.length != 3) {
            throw new Exception("Invalid Input Format");
        }
        return parts;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression (e.g., 1 + 2):");
        String input = scanner.nextLine();

        try {
            String[] parts = calculator.parseInput(input);
            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);

            int result = calculator.calculate(operator, a, b);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


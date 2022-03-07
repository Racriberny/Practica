package com.cristobalbernal.Practica.Lib;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lib {
    private static final Scanner lector = new Scanner(System.in);
    public static String leerLinea() {
        do {
            try {
                return lector.nextLine();
            }catch (InputMismatchException nme){
                System.out.println("Error: ");
            }
        }while (true);
    }

    public static int leerInt() {
        do {
            try {
                return Integer.parseInt(leerLinea());
            } catch (NumberFormatException nfe) {
                System.out.println("El valor introducido no es un número valido!");
                System.out.println("Escribe otro numero: ");
            }
        } while (true);
    }

    public static int leerInt(int min, int max) {
        do {
            int numero = leerInt();

            if (min != -1 && numero < min) {
                System.out.println("El número no puede ser menor que: " + min);
            } else if (max != -1 && numero > max) {
                System.out.println("El número no puede mayor que: " + max);
            } else {
                return numero;
            }
        } while (true);
    }

    public static double leerDouble() {
        do {
            try {
                return Double.parseDouble(leerLinea());
            } catch (NumberFormatException nfe) {
                System.out.println("El valor introducido no es un número valido!");
                System.out.println("Escribe otro numero: ");
            }
        } while (true);
    }
    public static float leerFloat() {
        do {
            try {
                return Float.parseFloat(leerLinea());
            } catch (NumberFormatException nfe) {
                System.out.println("El valor introducido no es un número valido!");
                System.out.println("Escribe otro numero: ");
            }
        } while (true);
    }

    public static char leerChar(){
        return lector.next().charAt(0);
    }

    public static int numeroAleatorio(int MIN, int MAX){
        Random r = new Random();
        return r.nextInt(MAX - MIN + 1) + MIN;
    }

    public static double numeroAleatorioDouble(int MIN, int MAX){
        Random r = new Random();
        return MIN + (MAX - MIN) * r.nextDouble();
    }

    public void espera(int x){
        try {
            Thread.sleep(x);
        }catch (InterruptedException ie){

        }
    }

    public static int[] arrayInt(int[]array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println("Introduce un numero");
            array[i] = leerInt();
        }return array;
    }
    public static double[] arrayDouble(double[]array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println("Introduce un numero");
            array[i] = leerDouble();
        }return array;
    }
    public static String[] arrayString(String[]array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println("Introduce una palabra");
            array[i] = leerLinea();
        }return array;
    }
    public static char[] arrayChar(char[]array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println("Introduce una letra");
            array[i] = leerChar();
        }return array;
    }

    public static void arrayAlea(int [] array,int min,int max){
        for (int i = 0; i < array.length ; i++) {
            array[i] = numeroAleatorio(min,max);
        }
    }

    public static void visualizarArraysInt(int[] array){
        System.out.println(Arrays.toString(array));
    }
    public static void visualizarArraysChar(char[] array){
        System.out.println(Arrays.toString(array));
    }
    public static void visualizarArraysString(String[] array){
        System.out.println(Arrays.toString(array));
    }

    public static void visualizarArraysDouble(double[] array){
        System.out.println(Arrays.toString(array));
    }

    public static int[][] rellenarMatrix(int[][] array,int MIN,int MAX){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = numeroAleatorio(MIN,MAX);
            }
        }
        return array;
    }
    public static void visulizarMatrix(int[][] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print("Fila " + i + " : ");
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static char[] rellenarArrayLetrasMayus(char[] array, final String LETRAS) {
        final int VALOR_MIN = 0;
        final int VALOR_MAX = LETRAS.length()-1;

        for(int i = 0; i < array.length; i++) {
            array[i] = LETRAS.charAt(Lib.numeroAleatorio(VALOR_MIN, VALOR_MAX));
        }

        return array;
    }
    public static void visulizarMatrix(double[][] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print("Fila " + i + " : ");
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void pausa() {
        System.out.println("Pulsa INTRO para continuar");
        Lib.leerLinea();
    }
    public static boolean booleanAlea(){
        Random r = new Random();
        return r.nextBoolean();
    }
}

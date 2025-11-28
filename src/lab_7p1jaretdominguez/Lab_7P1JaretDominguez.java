/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_7p1jaretdominguez;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author JARET DOMINGUEZ
 */
public class Lab_7P1JaretDominguez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" MENU ");
            System.out.println("0. Bonus");
            System.out.println("1. Suma en Z");
            System.out.println("2. Matriz Traspuesta");
            System.out.println("3. Rotacion Matricial");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Ejercicio Bonus ejecutado");
                 ejerciciobonus(leer);
                        break;
                case 1:
                    System.out.println("Ejercicio 1 ejecutado");
                   Ejercicio1(leer);
                    break;
                case 2:
                    System.out.println("Ejercicio 2 ejecutado");
                    
                    break;
                case 3:
                    System.out.println("Ejercicio 3 ejecutado");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo");
            }

        } while (opcion != 4);

    }
    
      public static void Ejercicio1(Scanner lea) {
          Scanner leer = new Scanner(System.in);
          System.out.println("ingrese el valor de la matriz");
          System.out.println("debe ser mayor que 3 e impar");
        System.out.println(": ");
             int  tamanofilas = leer.nextInt();
             int tamanocolumnas = tamanofilas;           
        int[][] matriz = new int[tamanofilas][tamanocolumnas];
        imprimirtabla(matriz);

    }

    public static void imprimirtabla(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Random randi = new Random();
                matriz[i][j] = randi.nextInt(9);
                System.out.print("[" + matriz[i][j] + "]");
                System.out.print("");

            }
            System.out.println();
        }

    }

       public static void imprimirTabla(boolean[][] tabla) {
        System.out.println("Tabla resultante:");
        System.out.println("p  q  r");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(
                    (tabla[i][0] ? 1 : 0) + "  "
                    + (tabla[i][1] ? 1 : 0) + "  "
                    + (tabla[i][2] ? 1 : 0)
            );
        }
    }

    public static void ejerciciobonus(Scanner leer) {
        System.out.print("Ingrese numero de filas: ");
        int filas = leer.nextInt();

        boolean[][] propuestas = generarPropuestas(filas);
        imprimirMatriz(propuestas);

        leer.nextLine();
        System.out.print("Ingrese operacion logica (pvq o pnq): ");
        String operacion = leer.nextLine();

        boolean[][] tabla;
        if (operacion.equals("pvq")) {
            tabla = operacionOr(propuestas);
        } else if (operacion.equals("pnq")) {
            tabla = operacionAnd(propuestas);
        } else {
            System.out.println("Operacion invalida");
            return;
        }

        imprimirTabla(tabla);
    }

    public static boolean[][] operacionOr(boolean[][] matriz) {
        boolean[][] resultado = new boolean[matriz.length][3];
        for (int i = 0; i < matriz.length; i++) {
            resultado[i][0] = matriz[i][0];
            resultado[i][1] = matriz[i][1];
            resultado[i][2] = matriz[i][0] || matriz[i][1];
        }
        return resultado;
    }

    public static boolean[][] operacionAnd(boolean[][] matriz) {
        boolean[][] resultado = new boolean[matriz.length][3];
        for (int i = 0; i < matriz.length; i++) {
            resultado[i][0] = matriz[i][0];
            resultado[i][1] = matriz[i][1];
            resultado[i][2] = matriz[i][0] && matriz[i][1];
        }
        return resultado;
    }
        public static boolean[][] generarPropuestas(int filas) {
        Random randi = new Random();
        boolean[][] matriz = new boolean[filas][2];
        for (int i = 0; i < filas; i++) {
            matriz[i][0] = randi.nextBoolean();
            matriz[i][1] = randi.nextBoolean();
        }
        return matriz;
    }

    public static void imprimirMatriz(boolean[][] matriz) {
        System.out.println("Matriz (p, q):");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println((matriz[i][0] ? 1 : 0) + "  " + (matriz[i][1] ? 1 : 0));
        }
    }
    

    //String[][] tablero = new String[][];

    

       
        }
    


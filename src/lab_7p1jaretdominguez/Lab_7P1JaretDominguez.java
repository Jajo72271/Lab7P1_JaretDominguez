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
        System.out.println("debe ser mayor que 3 ");
        System.out.println(": ");
        int tamanofilas = leer.nextInt();
        if (tamanofilas > 3) {
            int tamanocolumnas = tamanofilas;
            int[][] matriz = new int[tamanofilas][tamanocolumnas];
            imprimirtabla(matriz);
            int total = recorrerTabla1(matriz) + recorrerTabla12(matriz) + recorrerTabla13(matriz);
            System.out.println("el total del Z invertido es: " + total);
            int total2 = recorrerTabla1(matriz) + recorrerTabla22(matriz) + recorrerTabla13(matriz);
            System.out.println("el total del Z normal es: " + total2);
            int diferencia = Math.abs(21 - total);
            int diferencia2 = Math.abs(21 - total2);
            int verificacion = diferencia - diferencia2;
            if (verificacion > 0) {
                System.out.println("la Z Normal es mas cercano a 21");
            } else {
                System.out.println("la Z invertido es mas cercano a 21");
            }

        }
        System.out.println("debe ser mayor a 3");
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
     public static int recorrerTabla1(int[][] matriz) {
         int acumulador = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            int numero = matriz[0][i];
            acumulador = numero + acumulador;
        }
         
         return acumulador;
     }
        public static int recorrerTabla12(int[][] matriz) {
         int acumulador = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (j==i) {
                    if (i!=0&&i!=matriz.length-1) {
                        int numero = matriz [i][j];
                    acumulador = numero + acumulador;
                        
                    }
                   
                }
                
                
            }
            
        }
        
        return acumulador;
    }
        

    public static int recorrerTabla13(int[][] matriz) {
        int acumulador = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            int numero = matriz[matriz.length-1][i];
            acumulador = numero + acumulador;

        }
        
        return acumulador;
    }
    
    public static int recorrerTabla22(int[][] matriz) {
        int acumulador = 0;
        for (int i = 0; i < matriz[0].length-1; i++) {
            for (int j = 0; j < matriz.length-1; j++) {
                if ((matriz.length-1)-i == j) {
                    if (i!=0 && i!=matriz.length-1) {
                         int numero = matriz [i][j];
                    acumulador = numero + acumulador;
                    }
                }
            }
        }
    
    return acumulador;
    }

       public static void imprimirTabla(boolean[][] tabla) {
        System.out.println("Tabla resultante:");
        System.out.println("p  q  r");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println( (tabla[i][0] ? 1 : 0) + "  " + (tabla[i][1] ? 1 : 0) + "  " + (tabla[i][2] ? 1 : 0) );
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
    


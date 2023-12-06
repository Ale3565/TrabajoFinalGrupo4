package main;

import java.util.Scanner;

public class TrabajoFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la cantidad de estudiantes
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidadEstudiantes = scanner.nextInt();

        // Arreglos para almacenar datos de estudiantes
        String[] nombres = new String[cantidadEstudiantes];
        String[] apellidos = new String[cantidadEstudiantes];
        String[] identificadores = new String[cantidadEstudiantes];
        String[] detallesRelevantes = new String[cantidadEstudiantes];
        double[][] notas = new double[cantidadEstudiantes][3]; // Tres evaluaciones por estudiante
        double[] pesos = new double[3]; // Pesos para cada evaluación
    }

}
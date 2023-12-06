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

        // Ingreso de datos de estudiantes
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("\nIngrese los datos para el estudiante " + (i + 1) + ":");
            scanner.nextLine(); // Limpiar el buffer del teclado

            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();

            System.out.print("Apellido: ");
            apellidos[i] = scanner.nextLine();

            System.out.print("Identificador único: ");
            identificadores[i] = scanner.nextLine();

            System.out.print("Detalles relevantes: ");
            detallesRelevantes[i] = scanner.nextLine();

            // Ingreso de notas y pesos para cada estudiante
            System.out.println("\nIngreso de notas y pesos para " + nombres[i] + " " + apellidos[i]);
            for (int j = 0; j < 3; j++) {
                // Ingreso de notas con validación
                do {
                    System.out.print("Ingrese la nota de la evaluación " + (j + 1) + ": ");
                    notas[i][j] = scanner.nextDouble();
                    if (notas[i][j] < 0 || notas[i][j] > 20) {
                        System.out.println("¡Error! La nota debe estar en el rango de 0 a 20.");
                    }
                } while (notas[i][j] < 0 || notas[i][j] > 20);

                // Ingreso de pesos con validación
                do {
                    System.out.print("Ingrese el peso en porcentaje para la evaluación " + (j + 1) + ": ");
                    pesos[j] = scanner.nextDouble();
                    if (pesos[j] < 0 || pesos[j] > 100) {
                        System.out.println("¡Error! El peso debe estar en el rango de 0 a 100.");
                    }
                } while (pesos[j] < 0 || pesos[j] > 100);
            }

            // Validar que la suma de los pesos sea 100%
            if (!validarSumaPesos(pesos)) {
                System.out.println("¡Error! La suma de los pesos debe ser 100%. Reinicie el ingreso para este estudiante.");
                i--; // Repetir el ingreso para el mismo estudiante
            }
        }

        // Cálculo automático de promedios finales ponderados
        double[] promediosFinales = new double[cantidadEstudiantes];
        for (int i = 0; i < cantidadEstudiantes; i++) {
            promediosFinales[i] = calcularPromedioPonderado(notas[i], pesos);
        }

        // Generación de reportes académicos detallados
        System.out.println("\nReporte Académico Detallado:");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("\nEstudiante: " + nombres[i] + " " + apellidos[i]);
            System.out.println("Identificador único: " + identificadores[i]);
            System.out.println("Detalles relevantes: " + detallesRelevantes[i]);
            System.out.println("Promedio Final Ponderado: " + promediosFinales[i]);
        }
    }
    // Método para validar que la suma de los pesos sea 100%
    private static boolean validarSumaPesos(double[] pesos) {
        double sumaPesos = 0;
        for (double peso : pesos) {
            sumaPesos += peso;
        }
        return sumaPesos == 100;
    }

    // Método para calcular el promedio ponderado
    private static double calcularPromedioPonderado(double[] notas, double[] pesos) {
        double sumaNotasPonderadas = 0;

        for (int i = 0; i < notas.length; i++) {
            sumaNotasPonderadas += notas[i] * (pesos[i] / 100);
        }

        return sumaNotasPonderadas;
    }

}
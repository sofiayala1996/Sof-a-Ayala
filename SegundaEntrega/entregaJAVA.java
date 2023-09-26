
/*Hacer un programa que solicite una nota al usuario y dependiendo de la misma imprimir por pantalla, la nota y el detalle siguiente:
-Insuficiente: 0 - 3
-Suficiente: 4
-Bien: 5 y 6
-Notable: 7 y 8
-Sobresaliente: 9 y 10*/

import java.util.Scanner;
public class ProgramaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una nota (0 al 10): ");
        int nota = scanner.nextInt();
        if (nota >= 0 && nota <= 10) {
            System.out.print("Nota: " + nota + " - ");
            if (nota >= 0 && nota <= 3) {
                System.out.println("Insuficiente. ¡Seguí intentando!");
            } else if (nota == 4) {
                System.out.println("Suficiente. ¡Bien!");
            } else if (nota >= 5 && nota <= 6) {
                System.out.println("Bien. ¡Segui asi!");
            } else if (nota >= 7 && nota <= 8) {
                System.out.println("Notable. ¡Excelente trabajo!");
            } else {
                System.out.println("Sobresaliente. ¡Felicitaciones!");
            }
        } else {
            System.out.println("Error: La nota debe estar entre 0 y 10.");
        }
        scanner.close();
    }
}

/* Hacer un programa que solicite al usuario un número entre 0 y 9.999 e imprimir por pantalla cuántas cifras tiene este número.
Si el valor ingresado por el usuario es menor a cero o mayor a 9.999 deberá informar que no pertenece al rango solicitado.*/

import java.util.Scanner;
public class ContarCifras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entre 0 y 9,999: ");
        int numero = scanner.nextInt();
        if (numero >= 0 && numero <= 9999) {
            int cifras = contarCifras(numero);
            System.out.println("Número ingresado: " + numero);
            System.out.println("Cantidad de cifras: " + cifras);
        } else {
            System.out.println("Error: El número no pertenece al rango solicitado.");
        }
        scanner.close();
    }
    // Función para contar la cantidad de cifras en un número
    public static int contarCifras(int numero) {
        if (numero == 0) {
            return 1;
        }
        int cifras = 0;
        while (numero > 0) {
            cifras++;
            numero /= 10;
        }
        return cifras;
    }
}

/* Hacer un programa que solicite al usuario cinco numeros y los ordene de menor a mayor, y luego de mayor a menor. (imprime por consola)*/

import java.util.Scanner;

public class OrdenarMenorAMayor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        // El usuario ingresa 5 números
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el número #" + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Ordenar los números de menor a mayor
        for (int i = 0; i < 5 - 1; i++) {
            for (int j = 0; j < 5 - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiar los números
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Imprimir los números ordenados de menor a mayor
        System.out.println("Números ordenados de menor a mayor:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        scanner.close();
    }
}

/*Hacer un programa que solicite al usuario un número de 3 dígitos e imprimir por consola TODOS los valores PARES desde el cero hasta el número ingresado.*/

import java.util.Scanner;

public class NumerosPares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número de 3 dígitos: ");
        int numero = scanner.nextInt();

        if (numero >= 100 && numero <= 999) {
            System.out.println("Valores pares desde 0 hasta " + numero + ":");
            
            for (int i = 0; i <= numero; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Error: El número debe ser de 3 dígitos.");
        }

        scanner.close();
    }
}

/* Hacer un programa que solicite al usuario un número N, introducir N sueldos e imprimir por pantalla:
-El sueldo más alto
-El sueldo más bajo
-El promedio de TODOS los sueldos ingresados*/


import java.util.Scanner;

public class CalculadoraSueldos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de sueldos a introducir: ");
        int n = scanner.nextInt();

        if (n > 0) {
            double[] sueldos = new double[n];
            
            // Solicitar al usuario ingresar los sueldos
            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese el sueldo #" + (i + 1) + ": ");
                sueldos[i] = scanner.nextDouble();
            }

            // sueldo más alto y sueldo más bajo
            double sueldoMaximo = sueldos[0];
            double sueldoMinimo = sueldos[0];
            double sumaSueldos = sueldos[0];

            for (int i = 1; i < n; i++) {
                if (sueldos[i] > sueldoMaximo) {
                    sueldoMaximo = sueldos[i];
                }
                if (sueldos[i] < sueldoMinimo) {
                    sueldoMinimo = sueldos[i];
                }
                sumaSueldos += sueldos[i];
            }

            // Calcular el promedio
            double promedio = sumaSueldos / n;

            // Imprimir resultados
            System.out.println("Sueldo más alto: " + sueldoMaximo);
            System.out.println("Sueldo más bajo: " + sueldoMinimo);
            System.out.println("Promedio de sueldos: " + promedio);
        } else {
            System.out.println("Error: La cantidad de sueldos debe ser mayor que cero.");
        }

        scanner.close();
    }
}

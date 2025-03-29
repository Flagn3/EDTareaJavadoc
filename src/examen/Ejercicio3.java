package examen;

import java.util.Scanner;

/**
 * Esta clase permite introducir por consola un número de filas y generar un
 * triángulo que imprima en cada fila los números impares de forma decreciente.
 * El programa seguirá pidiendo un número de filas hasta que se introduzca un
 * número negativo o 0. Si se introduce un valor que no sea un número entero, se
 * mostrará un mensaje de error.
 */
public class Ejercicio3 {

	/**
	 * Método main que se ejecuta al iniciar el programa y pedirá por consola un
	 * número de filas.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Objeto Scanner para leer la entrada por consola
		Scanner sc = new Scanner(System.in);
		// Variable booleana utilizada para salir del bucle
		boolean exit = false;

		do {
			System.out.println("Introduce un número de filas: ");
			try {
				// Variable que almacena el número de filas introducido por el usuario
				int num = Integer.parseInt(sc.nextLine());
				// Salir del programa si el número introducido es negativo o 0
				if (num <= 0) {
					exit = true;
				} else {
					// Llamada al método que pinta el triángulo
					pintarTriangulo(num);
				}
			} catch (NumberFormatException ex) {
				// Mensaje de error que se muestra al no introducir un número entero
				System.out.println("El valor introducido no es un número entero.");
			}

		} while (!exit);
		System.out.println("Programa finalizado.");

	}

	/**
	 * Método que generará el triángulo con tantas filas como indique el número
	 * recibido como parámetro
	 * 
	 * @param num número de filas que el usuario desea que tenga el triángulo
	 * @throws NumberFormatException si el valor introducido no es un número entero
	 */
	private static void pintarTriangulo(int num) throws NumberFormatException {

		// Bucle que recorre las filas del triángulo
		for (int fila = 1; fila <= num; fila++) {
			// Variable que calcula el primer término de la fila
			int termino = 2 * fila - 1;
			// Bucle que recorre las columnas de la fila e imprime el término
			for (int columna = 1; columna <= fila; columna++) {
				System.out.print(termino + " ");
				// Decrementa en 2 el término para obtener el siguiente número impar
				termino -= 2;
			}
			// Salto de línea al terminar de imprimir una fila completa
			System.out.println();
		}

	}

}
